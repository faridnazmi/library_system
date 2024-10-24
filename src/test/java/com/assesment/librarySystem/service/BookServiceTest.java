package com.assesment.librarySystem.service;

import com.assessment.librarySystem.entity.BookEntity;
import com.assessment.librarySystem.repository.BookDao;
import com.assessment.librarySystem.service.BookService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private BookDao bookDao;

    @InjectMocks
    private BookService bookService;

    @Autowired
    public BookServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addBook_ShouldSaveBook_WhenValidBook() {
        BookEntity book = new BookEntity();
        book.setBookIsbnNo("123456789");
        book.setBookTitle("Test Book");
        book.setBookAuthor("Test Author");

        when(bookDao.save(any(BookEntity.class))).thenReturn(book);

        BookEntity savedBook = bookService.addBook(book);

        assertNotNull(savedBook);
        assertEquals("Test Book", savedBook.getBookTitle());
        verify(bookDao, times(1)).save(book);
    }

    @Test
    void getBookById_ShouldReturnBook_WhenExists() {
        Long bookId = 1L;
        BookEntity book = new BookEntity();
        book.setBookId(bookId);
        book.setBookIsbnNo("123456789");
        book.setBookTitle("Test Book");
        book.setBookAuthor("Test Author");

        when(bookDao.findById(bookId)).thenReturn(Optional.of(book));

        BookEntity foundBook = bookService.getBookById(bookId);

        assertNotNull(foundBook);
        assertEquals("Test Book", foundBook.getBookTitle());
    }

    @Test
    void getBookById_ShouldThrowException_WhenNotFound() {
        Long bookId = 1L;

        when(bookDao.findById(bookId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> bookService.getBookById(bookId));
    }
}
