package com.rikkei.session8.service;

import com.rikkei.session8.model.dto.request.BookCreateDTO;
import com.rikkei.session8.model.dto.request.BorrowBookDTO;
import com.rikkei.session8.model.entity.Borrow;

public interface BorrowService {
    Borrow createBorrow(BorrowBookDTO borrow);
    Borrow returnBook(Long bookId);
}
