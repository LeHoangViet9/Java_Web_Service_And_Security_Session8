package com.rikkei.session8.model.dto.request;

import com.rikkei.session8.Custom_validator.BookExisted;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookDTO {
    @NotBlank(message = "User name cannot blank")
    private String userName;
    @BookExisted
    private Long bookId;
}
