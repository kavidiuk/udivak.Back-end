<<<<<<< Updated upstream:src/main/java/capstone/udivak/Exceptions/NotFoundException.java
package capstone.udivak.Exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("L'utente con id " + id + " non è stato trovato");
    }
    public NotFoundException(long id) {
        super("la provincia/municipio con id " + id + " non è stato trovato");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
=======
package capstone.udivak.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("L'utente con id " + id + " non è stato trovato");
    }
    public NotFoundException(long id) {
        super("la provincia/municipio con id " + id + " non è stato trovato");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
>>>>>>> Stashed changes:src/main/java/capstone/udivak/exceptions/NotFoundException.java
