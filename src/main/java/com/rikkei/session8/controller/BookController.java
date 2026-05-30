package com.rikkei.session8.controller;

import com.rikkei.session8.model.dto.request.BookCreateDTO;
import com.rikkei.session8.model.dto.request.BookUpdateDTO;
import com.rikkei.session8.model.dto.request.BorrowBookDTO;
import com.rikkei.session8.model.dto.response.ApiDataResponse;
import com.rikkei.session8.model.dto.response.ErrorsResponse;
import com.rikkei.session8.model.entity.Book;
import com.rikkei.session8.service.BookService;
import jakarta.validation.Valid;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
    private final BookService bookService;
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Book>> createBook(@Valid @ModelAttribute BookCreateDTO book) {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    true,
                    "Add book "+book.getTitle()+" successfully",
                    bookService.createBookDTO(book),
                    null,
                    HttpStatus.CREATED
            ), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<ApiDataResponse<Book>> updateStockBooj(@PathVariable Long id, @Valid @RequestBody BookUpdateDTO bookUpdateDTO) {
        Book updateBook=bookService.updateBook(id, bookUpdateDTO);
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Update book successfully",
                updateBook,
                null,
                HttpStatus.OK
        ),HttpStatus.OK);
    }


}
