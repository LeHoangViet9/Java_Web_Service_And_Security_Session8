package com.rikkei.session8.controller;

import com.rikkei.session8.model.dto.request.ReaderCreateDTO;
import com.rikkei.session8.model.dto.response.ApiDataResponse;
import com.rikkei.session8.model.entity.Reader;
import com.rikkei.session8.service.ReaderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderService readerService;

    @PostMapping
    public ResponseEntity<ApiDataResponse<Reader>> createReader(@Valid @ModelAttribute ReaderCreateDTO reader) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Add reader successfully",
                readerService.createReader(reader),
                null,
                HttpStatus.CREATED
        ),HttpStatus.CREATED);
    }
}
