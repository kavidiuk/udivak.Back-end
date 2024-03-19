package capstone.udivak.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorsPayloads{
    private String message;
    private LocalDateTime timestamp;
}