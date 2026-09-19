package in.bean.day06springbootexceptionhandling.globalexceptionhandler;

import java.time.LocalDateTime;

public record ErrorResponse(int status, String message, LocalDateTime timestamp) {
}
