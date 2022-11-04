package com.vmo.fresher.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private LocalDate dob;

}
