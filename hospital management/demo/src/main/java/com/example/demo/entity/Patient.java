package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@Getter
@Setter
@Table(
//        name="patients_table",
        uniqueConstraints = {
                @UniqueConstraint(name = "email_unique", columnNames = "email")
        },
        indexes = {
                @Index(name = "birthdate_idx", columnList = "birthdate")
        }

)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ToString.Exclude
    private LocalDate birthdate;

    private String email;
    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
