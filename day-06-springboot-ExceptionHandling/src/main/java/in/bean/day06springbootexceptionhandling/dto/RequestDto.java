package in.bean.day06springbootexceptionhandling.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;


    @Email(message = "Enter a valid email address")
    private String email;

    @NotNull(message = "Roll number is required")
    @Positive(message = "Roll number must be positive")
    private Integer rollNo;   // int → Integer, kyunki @NotNull primitive int pe useless hai

    @NotBlank(message = "Subject is Required")
    private String subject;



}
