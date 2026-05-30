package com.rikkei.session8.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "readers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reader {
//    d: Long (Primary Key, Auto Increment).
//    email: String (Unique, Not Null).
//    fullName: String.
//            phoneNumber: String.
//            address: String.
//            avatar: String
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "full_name")
    private String fullName;
    private String address;
    private String phone;
    private String avatar;
}
