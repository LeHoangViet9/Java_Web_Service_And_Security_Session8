package com.rikkei.session8.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookCreateDTO {
    //title, author, stock, MultipartFile coverImage.
    @NotBlank(message = "Title is not null")
    private String title;

    @NotBlank(message = "Author is not null")
    private String author;

    @NotNull(message = "Stock is not null")
    private Integer stock;

    @NotNull(message = "Cover image is not null")
    private MultipartFile coverImage;
}
