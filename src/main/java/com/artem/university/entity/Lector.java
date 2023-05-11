package com.artem.university.entity;

import com.artem.university.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "lectors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private Double salary;
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany
    private Set<Department> departments;
}
