package com.rikkei.session8.repository;

import com.rikkei.session8.model.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {
}
