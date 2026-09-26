package org.spring.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponseDto {
    private Long id;
    private String name;
    private String subject;
    private int rollNo;
    private int age;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String message;

}
