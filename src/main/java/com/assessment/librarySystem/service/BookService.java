package com.assessment.librarySystem.service;

import com.assessment.librarySystem.entity.BookEntity;
import com.assessment.librarySystem.entity.BorrowRecordEntity;
import com.assessment.librarySystem.entity.BorrowerEntity;
import com.assessment.librarySystem.repository.BookDao;
import com.assessment.librarySystem.repository.BorrowRecordDao;
import com.assessment.librarySystem.repository.BorrowerDao;
import com.assessment.librarySystem.dto.BookReqBean;
import com.assessment.librarySystem.dto.BookRespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@jakarta.transaction.Transactional
public class BookService {

	@Autowired
    private final BookDao bookDao;
    
    @Autowired
    private  BorrowerDao borrowerDao;
    
    @Autowired
    private BorrowRecordDao borrowRecordDao;

    @Autowired
    public BookService(BookDao bookDao) {
		this.bookDao = bookDao;
    }

    // Method to add a new book
    public BookRespBean addBook(BookReqBean bookRequest) {
        BookEntity book = new BookEntity();
        book.setBookIsbnNo(bookRequest.getBookIsbnNo());
        book.setBookTitle(bookRequest.getBookTitle());
        book.setBookAuthor(bookRequest.getBookAuthor());
        BookEntity savedBook = bookDao.save(book);
        return convertToRespBean(savedBook);
    }

    // Method to get all books
    public List<BookRespBean> getAllBooks() {
        List<BookEntity> books = bookDao.findAll();
        return books.stream()
                .map(this::convertToRespBean)
                .collect(Collectors.toList());
    }

    // Convert BookEntity to BookRespBean
    private BookRespBean convertToRespBean(BookEntity book) {
        BookRespBean response = new BookRespBean();
        response.setBookId(book.getBookId());
        response.setBookIsbnNo(book.getBookIsbnNo());
        response.setBookTitle(book.getBookTitle());
        response.setBookAuthor(book.getBookAuthor());
        return response;
    }
    public BorrowRecordEntity borrowBook(Long bookId, Long borrowerId) {
        Optional<BookEntity> optionalBook = bookDao.findById(bookId);
        Optional<BorrowerEntity> optionalBorrower = borrowerDao.findById(borrowerId);

        if (optionalBook.isPresent() && optionalBorrower.isPresent()) {
            // Check if the book is already borrowed
            if (bookDao.existsByBookId(bookId)) {
                throw new IllegalStateException("This book is already borrowed.");
            }

            BorrowRecordEntity borrowRecord = new BorrowRecordEntity();
            borrowRecord.setBook(optionalBook.get());
            borrowRecord.setBorrower(optionalBorrower.get());
            return borrowRecordDao.save(borrowRecord);
        } else {
            throw new IllegalArgumentException("Book or Borrower not found.");
        }
    }

    public void returnBook(Long bookId, Long borrowerId) {
        Optional<BorrowRecordEntity> optionalRecord = borrowRecordDao.findByBookIdAndBorrowerId(bookId, borrowerId);
        
        if (optionalRecord.isPresent()) {
            borrowRecordDao.delete(optionalRecord.get());
        } else {
            throw new IllegalArgumentException("No record found for this book and borrower.");
        }
    }
}
