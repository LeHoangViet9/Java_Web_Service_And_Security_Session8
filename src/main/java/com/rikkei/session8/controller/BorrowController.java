package com.rikkei.session8.controller;

import com.rikkei.session8.model.dto.request.BorrowBookDTO;
import com.rikkei.session8.model.dto.response.ApiDataResponse;
import com.rikkei.session8.model.entity.Borrow;
import com.rikkei.session8.service.BorrowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/borrows")
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService borrowService;
    @PostMapping
    public ResponseEntity<ApiDataResponse<Borrow>> borrowBook(@Valid @RequestBody BorrowBookDTO borrowBookDTO) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Borrow book successfully",
                borrowService.createBorrow(borrowBookDTO),
                null,
                HttpStatus.CREATED

        ),HttpStatus.CREATED);
    }
    @PatchMapping("/{id}/return")
    public ResponseEntity<ApiDataResponse<Borrow>> returnBook(@PathVariable Long id){
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Return book successfully",
                borrowService.returnBook(id),
                null,
                HttpStatus.OK
        ),HttpStatus.OK);
    }
}
