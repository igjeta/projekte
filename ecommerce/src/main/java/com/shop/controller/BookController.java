package com.shop.controller;

import com.shop.domain.dto.book.BookDisplayAdminDto;
import com.shop.domain.dto.book.BookDisplayDto;
import com.shop.domain.dto.book.BookDto;
import com.shop.domain.entity.BookEntity;
import com.shop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDisplayDto> displayBooks() {
        return bookService.findAllBooksEnabledTrue();
    }

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    public ResponseEntity<String> createBook(@RequestBody BookDto bookCreateDto) {
        bookService.createBook(bookCreateDto);
        return ResponseEntity.ok("Book was created successfully!");
    }


    @PutMapping("/update/{bookId}")
    public ResponseEntity<String> updateBook(@RequestBody BookDto bookUpdateDto, @PathVariable Integer bookId) {
        bookService.updateBook(bookUpdateDto, bookId);
        return ResponseEntity.ok("Book was updated successfully!");
    }

    @GetMapping("/admin/all")
    public List<BookDisplayAdminDto> getAllBooksAdmin() {
        return bookService.findAllBooksAdmin();
    }


    @PutMapping("/action/{bookId}")
    public ResponseEntity<String> bookAction(@PathVariable Integer bookId,@RequestParam Boolean enabled){
        bookService.bookAction(bookId,enabled);
        String action = enabled ? "enabled" : "disabled";
        return ResponseEntity.ok("Book with id " + bookId + " has been " + action + " successfully!");
    }
}
