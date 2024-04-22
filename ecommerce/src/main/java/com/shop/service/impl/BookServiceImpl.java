package com.shop.service.impl;

import com.shop.domain.dto.book.BookDisplayAdminDto;
import com.shop.domain.dto.book.BookDisplayDto;
import com.shop.domain.dto.book.BookDto;
import com.shop.domain.entity.BookEntity;
import com.shop.domain.entity.GenreEntity;
import com.shop.domain.entity.OrderItemEntity;
import com.shop.domain.entity.UserEntity;
import com.shop.domain.exceptions.ClassicModelException;
import com.shop.repository.BookRepository;
import com.shop.repository.GenreRepository;
import com.shop.repository.UserRepository;
import com.shop.service.BookService;
import com.shop.util.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.shop.domain.mapper.BookCreateUpdateMapper.BOOK_CREATE_UPDATE_MAPPER;
import static com.shop.domain.mapper.BookDisplayMapper.BOOK_DISPLAY_MAPPER;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityContextHelper securityContextHelper;

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<BookDisplayDto> findAllBooksEnabledTrue() {

        List<BookEntity> books = bookRepository.findAllByEnabledTrue();

        return books.stream()
                .map(BOOK_DISPLAY_MAPPER::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createBook(BookDto bookCreateDto) {

        String email = securityContextHelper.getCurrentUserEmail();
        UserEntity user = userRepository.findByEmailAndEnabledIsTrue(email)
                .orElseThrow(() -> new ClassicModelException("User not found for create"));

        Optional<BookEntity> bookToCheck = bookRepository.findByTitleAndEnabledTrue(bookCreateDto.getTitle());
        if (bookToCheck.isPresent()) {
            throw new ClassicModelException("Book with title " + bookCreateDto.getTitle() + " already exists!");
        }

        Optional<GenreEntity> genreCheck = genreRepository.findByIdAndEnabledTrue(bookCreateDto.getGenreId());
        if (genreCheck.isEmpty()) {
            throw new ClassicModelException("Genre is not provided correctly!");
        }

        BookEntity bookToAdd = BOOK_CREATE_UPDATE_MAPPER.toEntity(bookCreateDto);
        bookToAdd.setCreatedAt(LocalDateTime.now());
        bookToAdd.setCreatedBy(user);
        bookToAdd.setGenre(genreCheck.get());
        bookToAdd.setEnabled(true);

        bookRepository.save(bookToAdd);
    }

    @Override
    public void updateBook(BookDto bookUpdateDto, Integer bookId) {

        String email = securityContextHelper.getCurrentUserEmail();
        UserEntity user = userRepository.findByEmailAndEnabledIsTrue(email)
                .orElseThrow(() -> new ClassicModelException("User not found for update"));

        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ClassicModelException("Book with id " + bookId + " was not found to be updated"));

        Optional<BookEntity> bookOptionalTitleCheck = bookRepository.findByTitleAndIdNot(bookUpdateDto.getTitle(), bookId);
        if (bookOptionalTitleCheck.isPresent()) {
            throw new ClassicModelException("This Book title " + bookUpdateDto.getTitle() + " exists on another book and cannot be duplicated");
        }
        BookEntity bookToUpdate = BOOK_CREATE_UPDATE_MAPPER.toEntity(bookUpdateDto);
        bookToUpdate.setId(book.getId());

        GenreEntity genre = genreRepository.findByIdAndEnabledTrue(bookUpdateDto.getGenreId())
                .orElseThrow(() -> new ClassicModelException("Genre id is not provided correctly"));

        bookToUpdate.setGenre(genre);
        bookToUpdate.setCreatedAt(book.getCreatedAt());
        bookToUpdate.setModifiedAt(LocalDateTime.now());
        bookToUpdate.setCreatedBy(book.getCreatedBy());
        bookToUpdate.setModifiedBy(user);
        bookToUpdate.setEnabled(book.isEnabled());
        bookRepository.save(bookToUpdate);
    }

    @Override
    public List<BookDisplayAdminDto> findAllBooksAdmin() {
        List<BookEntity> books = bookRepository.findAll();

        return books.stream()
                .map(bookEntity -> {
                    BookDisplayAdminDto dto = BOOK_DISPLAY_MAPPER.toDtoAdmin(bookEntity);
                    dto.setGenreId(bookEntity.getGenre().getId());
                    dto.setCreatedBy(bookEntity.getCreatedBy().getId());
                    if (bookEntity.getModifiedBy() == null) {
                        dto.setModifiedBy(-1);
                    } else {
                        dto.setModifiedBy(bookEntity.getModifiedBy().getId());
                    }
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void bookAction(Integer bookId,Boolean enabled) {
        BookEntity bookAction = bookRepository.findById(bookId)
                .orElseThrow(() -> new ClassicModelException("Book with id " + bookId + " was not found"));
        bookAction.setEnabled(enabled);
        bookRepository.save(bookAction);
    }

    @Override
    public List<BookEntity> findAllBooksEntitiesByIds(Set<Integer> bookIds) {
        return bookRepository.findAllByEnabledTrueAndIdIn(bookIds);
    }

    @Override
    public BookEntity findBookEntityById(Integer bookId){
        return bookRepository.findByIdAndEnabledTrue(bookId)
                .orElseThrow(()-> new ClassicModelException("Book was not found with id "+bookId));
    }


    @Override
    public void removeQuantitiesAfterOrder(Map<Integer, Integer> itemsDto) {
        for (Map.Entry<Integer, Integer> entry : itemsDto.entrySet()) {
            Integer bookId = entry.getKey();
            Integer quantity = entry.getValue();

            BookEntity book = bookRepository.findById(bookId)
                    .orElseThrow(() -> new ClassicModelException("Book not found with ID: " + bookId));

            if (book.getQuantity() < quantity) {
                throw new IllegalArgumentException("Insufficient stock for book with ID: " + bookId);
            }

            book.setQuantity(book.getQuantity() - quantity);
            bookRepository.save(book);
        }
    }

    @Override
    public void restoreQuantities(List<OrderItemEntity> orderItems) {
        for (OrderItemEntity orderItem : orderItems) {
            BookEntity book = orderItem.getBook();
            Integer quantityToReturn = orderItem.getQuantity();
            book.setQuantity(book.getQuantity() + quantityToReturn);
            bookRepository.save(book);
        }
    }
}