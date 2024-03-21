package capstone.udivak.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorsPayloads{
    private String message;
    private LocalDateTime timestamp;
}