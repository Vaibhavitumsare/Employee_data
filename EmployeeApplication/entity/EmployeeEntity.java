package com.SpringProject.EmployeeApplication.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "emp")
public class EmployeeEntity {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private String email;

}
