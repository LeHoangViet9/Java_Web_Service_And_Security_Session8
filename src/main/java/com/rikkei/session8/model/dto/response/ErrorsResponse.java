package com.rikkei.session8.model.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;

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
    private HttpStatus status;
}
