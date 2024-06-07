package com.examm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @ElementCollection
    private List<String> skills;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeProject> projects;
}
