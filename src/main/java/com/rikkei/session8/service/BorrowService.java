package com.rikkei.session8.service;

import com.rikkei.session8.model.dto.request.BorrowCreateDTO;
import com.rikkei.session8.model.entity.Borrow;

public interface BorrowService {
    Borrow createBorrow(BorrowCreateDTO borrow);
    Borrow returnBook(Long bookId);
}
