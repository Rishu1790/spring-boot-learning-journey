package in.bean.day05springbootdtoandvalidation.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@jakarta.persistence.Entity
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
