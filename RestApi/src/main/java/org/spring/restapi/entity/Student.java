package org.spring.restapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;
import org.hibernate.id.IdentityGenerator;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private String name;
    private String subject;
    private int rollNo;
    private int age;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String message;
    private Boolean deleted;

}
