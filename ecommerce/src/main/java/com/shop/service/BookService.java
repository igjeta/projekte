package com.shop.service;

import com.shop.domain.dto.book.BookDisplayAdminDto;
import com.shop.domain.dto.book.BookDisplayDto;
import com.shop.domain.dto.book.BookDto;
import com.shop.domain.entity.BookEntity;
import com.shop.domain.entity.OrderItemEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface BookService {

    List<BookDisplayDto> findAllBooksEnabledTrue();

    void createBook(BookDto bookCreateDto);

    void updateBook(BookDto bookUpdateDto, Integer bookId);

    List<BookDisplayAdminDto> findAllBooksAdmin();

    void bookAction(Integer bookId, Boolean enabled);

    List<BookEntity> findAllBooksEntitiesByIds(Set<Integer> bookIds);
    BookEntity findBookEntityById(Integer bookId);

    void removeQuantitiesAfterOrder(Map<Integer, Integer> itemsDto);

    void restoreQuantities(List<OrderItemEntity> orderItems);

}
