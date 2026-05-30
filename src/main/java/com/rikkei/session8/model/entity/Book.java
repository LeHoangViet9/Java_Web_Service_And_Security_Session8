package com.rikkei.session8.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
//    Entity (Book): id (Long), title (String),
//    author (String), stock (Integer - số lượng tồn), coverUrl (String)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private Integer stock;
    private String coverUrl;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;

}
