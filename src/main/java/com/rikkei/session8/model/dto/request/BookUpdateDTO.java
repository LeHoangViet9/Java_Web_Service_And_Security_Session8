package com.rikkei.session8.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookUpdateDTO {
    @NotNull(message = "Stock is not null")
    @Min(value = 0, message = "Stock must be >= 0")
    private Integer stock;
}
