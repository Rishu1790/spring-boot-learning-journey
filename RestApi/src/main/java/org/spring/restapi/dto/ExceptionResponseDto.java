package org.spring.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDto {
    private LocalDateTime timeStamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;

}
