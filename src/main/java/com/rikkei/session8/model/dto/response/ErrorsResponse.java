package com.rikkei.session8.model.dto.response;

import lombok.*;

import java.security.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorsResponse {
    private boolean success;
    private String message;
    private LocalDateTime timestamp;
}
