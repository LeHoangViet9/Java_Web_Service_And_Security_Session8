package com.rikkei.session8.model.dto.request;

import com.rikkei.session8.Custom_validator.ExistingBookId;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowCreateDTO {
    @NotBlank(message = "User name cannot blank")
    private String userName;
    @ExistingBookId
    private Long bookId;
}
