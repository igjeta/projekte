package com.shop.service.impl;

import com.shop.domain.dto.order.AdminOrderDto;
import com.shop.domain.dto.order.OrderItemDto;
import com.shop.domain.dto.order.OrderSumDto;
import com.shop.domain.entity.*;
import com.shop.domain.exceptions.ClassicModelException;
import com.shop.repository.OrderItemRepository;
import com.shop.repository.OrderRepository;
import com.shop.repository.UserRepository;
import com.shop.service.BookService;
import com.shop.service.OrderItemService;
import com.shop.service.OrderService;
import com.shop.service.ShippingAddressService;
import com.shop.util.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityContextHelper securityContextHelper;

    @Autowired
    private BookService bookService;

    @Autowired
    private ShippingAddressService addressService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    @Transactional
    public void createOrderItems(Map<Integer, Integer> itemsDto, Integer addressId) {
        String email = securityContextHelper.getCurrentUserEmail();
        UserEntity user = userRepository.findByEmailAndEnabledIsTrue(email)
                .orElseThrow(() -> new ClassicModelException("User not found to create an order"));

        checkBookQuantities(itemsDto);

        ShippingAddressEntity address = addressService.findAddressByIdAndUser(addressId, user);

        OrderEntity order = orderService.createOrder(user, address);

        for (Map.Entry<Integer, Integer> entry : itemsDto.entrySet()) {
            Integer bookId = entry.getKey();
            Integer quantity = entry.getValue();
            BookEntity book = bookService.findBookEntityById(bookId);

            OrderItemEntity orderItem = OrderItemEntity.builder()
                    .book(book)
                    .order(order)
                    .quantity(quantity)
                    .price(book.getPrice())
                    .createdAt(LocalDateTime.now())
                    .build();
            orderItemRepository.save(orderItem);
        }
        bookService.removeQuantitiesAfterOrder(itemsDto);
    }


    private void checkBookQuantities(Map<Integer, Integer> itemsDtoMap) {

        Set<Integer> bookIds = itemsDtoMap.keySet();

        List<BookEntity> books = bookService.findAllBooksEntitiesByIds(bookIds);

        Map<Integer, BookEntity> bookMap = books.stream()
                .collect(Collectors.toMap(BookEntity::getId, book -> book));

        for (Map.Entry<Integer, Integer> entry : itemsDtoMap.entrySet()) {
            Integer bookId = entry.getKey();
            Integer quantity = entry.getValue();
            BookEntity book = bookMap.get(bookId);

            if (book == null || book.getQuantity() < quantity) {
                throw new ClassicModelException("Book with id " + bookId + " has not the quantity you want.");
            }
        }
    }

//    @Override
//    @Transactional
//    public void cancelOrder(Integer orderId) {
//        List<OrderItemEntity> orderItems = orderItemRepository.findByOrderId(orderId);
//
//        bookService.restoreQuantities(orderItems);
//
//        orderService.cancelOrder(orderId);
//    }

//    @Override
//    public OrderSumDto getOrderSum(Integer orderId) {
//        String email = securityContextHelper.getCurrentUserEmail();
//        UserEntity user = userRepository.findByEmailAndEnabledIsTrue(email)
//                .orElseThrow(() -> new ClassicModelException("User not found to show orders"));
//
//        var order = orderService.findOrderByUserAndId(user.getId(), orderId);
//
//        List<OrderItemEntity> orderItems = orderItemRepository.findByOrderId(orderId);
//
//        BigDecimal totalSum = BigDecimal.ZERO;
//        List<OrderItemDto> orderItemDTOs = new ArrayList<>();
//
//        for (OrderItemEntity orderItem : orderItems) {
//            BookEntity book = orderItem.getBook();
//            OrderItemDto orderItemDTO = OrderItemDto.builder()
//                    .bookTitle(book.getTitle())
//                    .quantity(orderItem.getQuantity())
//                    .price(orderItem.getPrice()).build();
//            totalSum = totalSum.add(orderItemDTO.getPrice().multiply(BigDecimal.valueOf(orderItemDTO.getQuantity())));
//            orderItemDTOs.add(orderItemDTO);
//        }
//
//        return new OrderSumDto(order.getId(), order.getStatus().toString(), totalSum, orderItemDTOs);
//    }
    @Override
    public List<OrderSumDto> getOrderSums() {
        String email = securityContextHelper.getCurrentUserEmail();
        UserEntity user = userRepository.findByEmailAndEnabledIsTrue(email)
                .orElseThrow(() -> new ClassicModelException("User not found to show orders"));

        List<OrderEntity> orders = orderService.findOrdersByUserId(user.getId());

        return orders.stream()
                .map(order -> {
                    List<OrderItemEntity> orderItems = orderItemRepository.findByOrderId(order.getId());
                    BigDecimal totalSum = BigDecimal.ZERO;
                    List<OrderItemDto> orderItemDTOs = new ArrayList<>();

                    for (OrderItemEntity orderItem : orderItems) {
                        BookEntity book = orderItem.getBook();
                        OrderItemDto orderItemDTO = OrderItemDto.builder()
                                .bookTitle(book.getTitle())
                                .quantity(orderItem.getQuantity())
                                .price(orderItem.getPrice()).build();
                        totalSum = totalSum.add(orderItemDTO.getPrice().multiply(BigDecimal.valueOf(orderItemDTO.getQuantity())));
                        orderItemDTOs.add(orderItemDTO);
                    }

                    return new OrderSumDto(order.getId(), order.getStatus().toString(), totalSum, orderItemDTOs);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<AdminOrderDto> getAllOrdersForAdmin() {
        List<OrderEntity> orders = orderRepository.findAll();
        List<AdminOrderDto> adminOrders = new ArrayList<>();

        for (OrderEntity order : orders) {
            List<OrderItemEntity> orderItems = orderItemRepository.findByOrderId(order.getId());
            List<OrderItemDto> adminOrderItems = new ArrayList<>();

            for (OrderItemEntity orderItem : orderItems) {
                OrderItemDto orderItemDto = OrderItemDto.builder()
                        .bookTitle(orderItem.getBook().getTitle())
                        .quantity(orderItem.getQuantity())
                        .price(orderItem.getPrice())
                        .build();
                adminOrderItems.add(orderItemDto);
            }

            AdminOrderDto adminOrder = new AdminOrderDto(order.getId(), order.getStatus(), order.getCreatedAt(), order.getModifiedAt(), adminOrderItems);
            adminOrders.add(adminOrder);
        }

        return adminOrders;
    }
}
