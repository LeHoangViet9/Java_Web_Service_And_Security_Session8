package com.rikkei.session8.service.impl;

import com.rikkei.session8.exception.BookAlreadyReturnException;
import com.rikkei.session8.exception.ResourceNotFoundException;
import com.rikkei.session8.model.dto.request.BorrowCreateDTO;
import com.rikkei.session8.model.entity.Book;
import com.rikkei.session8.model.entity.Borrow;
import com.rikkei.session8.model.entity.BorrowStatus;
import com.rikkei.session8.repository.BookRepository;
import com.rikkei.session8.repository.BorrowRepository;
import com.rikkei.session8.service.BorrowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;

    @Override
    public Borrow createBorrow(BorrowCreateDTO borrow) {
        Book book = bookRepository.findById(borrow.getBookId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Book not found"
                        ));

        if (book.getStock() <= 0) {

            throw new RuntimeException(
                    "Book is out of stock"
            );
        }

        book.setStock(book.getStock() - 1);

        bookRepository.save(book);
        Borrow b=Borrow.builder()
                .userName(borrow.getUserName())
                .book(book)
                .build();
        return borrowRepository.save(b);
    }

    @Override
    public Borrow returnBook(Long bookId) {
        Borrow borrow= borrowRepository.findById(bookId).orElseThrow(()->new ResourceNotFoundException("Book already returned"));
        if(borrow.getBorrowStatus() == BorrowStatus.RETURNED){
            throw new BookAlreadyReturnException("Book already returned");
        }
        borrow.setBorrowStatus(BorrowStatus.RETURNED);
        borrow.setReturnDate(LocalDateTime.now());
        Book book = borrow.getBook();
        book.setStock(book.getStock()+1);
        return borrowRepository.save(borrow);
    }
}
