package com.rikkei.session8.service;

import com.rikkei.session8.model.dto.request.BookCreateDTO;
import com.rikkei.session8.model.dto.request.BookUpdateDTO;
import com.rikkei.session8.model.entity.Book;

public interface BookService {
    Book createBookDTO(BookCreateDTO bookCreateDTO);
    Book updateBook(Long id,BookUpdateDTO bookUpdateDTO);
    Book getBookById(Long id);
}
