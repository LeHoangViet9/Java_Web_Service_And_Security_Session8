package com.rikkei.session8.Custom_validator;

import com.rikkei.session8.model.entity.Book;
import com.rikkei.session8.repository.BookRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class BookValidator implements ConstraintValidator<BookExisted, Long> {
    private final BookRepository repository;
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value != null) {
            return false;
        }
        return repository.existsById(value);
    }
}
