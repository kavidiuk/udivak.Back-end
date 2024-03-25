<<<<<<< Updated upstream:src/main/java/capstone/udivak/Exceptions/ErrorsPayloads.java
package capstone.udivak.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorsPayloads{
    private String message;
    private LocalDateTime timestamp;
=======
package capstone.udivak.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorsPayloads{
    private String message;
    private LocalDateTime timestamp;
>>>>>>> Stashed changes:src/main/java/capstone/udivak/exceptions/ErrorsPayloads.java
}