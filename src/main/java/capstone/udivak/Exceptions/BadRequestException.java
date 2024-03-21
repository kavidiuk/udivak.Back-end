<<<<<<< Updated upstream:src/main/java/capstone/udivak/Exceptions/BadRequestException.java
package capstone.udivak.Exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
public class BadRequestException extends RuntimeException {
    private List<ObjectError> errorsList;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(List<ObjectError> errorsList) {
        super("Errori nel payload");
        this.errorsList = errorsList;
    }
}

=======
package capstone.udivak.exceptions;

import lombok.Getter;
import org.springframework.validation.ObjectError;

import java.util.List;

@Getter
public class BadRequestException extends RuntimeException {
    private List<ObjectError> errorsList;

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(List<ObjectError> errorsList) {
        super("Errori nel payload");
        this.errorsList = errorsList;
    }
}

>>>>>>> Stashed changes:src/main/java/capstone/udivak/exceptions/BadRequestException.java
