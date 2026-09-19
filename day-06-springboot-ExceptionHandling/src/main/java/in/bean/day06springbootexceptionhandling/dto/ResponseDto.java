package in.bean.day06springbootexceptionhandling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private Long id;
    private String name;
    private String subject;
    private int age;
    private int rollNo;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String message;

}
