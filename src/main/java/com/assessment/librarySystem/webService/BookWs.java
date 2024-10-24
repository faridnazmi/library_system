package com.assessment.librarySystem.webService;

import com.assessment.librarySystem.dto.BookReqBean;
import com.assessment.librarySystem.dto.BookRespBean;
import com.assessment.librarySystem.entity.BorrowRecordEntity;
import com.assessment.librarySystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookWs {

    private final BookService bookService;

    @Autowired
    public BookWs(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @RequestMapping("/addBook")
    public ResponseEntity<BookRespBean> addBook(@Validated @RequestBody BookReqBean bookRequest) {
        BookRespBean createdBook = bookService.addBook(bookRequest);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/getAllBooks")
    public ResponseEntity<List<BookRespBean>> getAllBooks() {
        List<BookRespBean> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    @PostMapping("/{bookId}/borrow/{borrowerId}")
    public ResponseEntity<BorrowRecordEntity> borrowBook(@PathVariable Long bookId, @PathVariable Long borrowerId) {
        BorrowRecordEntity borrowRecord = bookService.borrowBook(bookId, borrowerId);
        return new ResponseEntity<>(borrowRecord, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}/return/{borrowerId}")
    public ResponseEntity<Void> returnBook(@PathVariable Long bookId, @PathVariable Long borrowerId) {
        bookService.returnBook(bookId, borrowerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
