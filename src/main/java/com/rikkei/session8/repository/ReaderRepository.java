package com.rikkei.session8.repository;

import com.rikkei.session8.model.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
    boolean existsByEmail(String email);
}
