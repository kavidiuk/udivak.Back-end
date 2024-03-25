package capstone.udivak.exceptions;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayloads handleBadRequest(BadRequestException ex) {
        if (ex.getMessage() != null) {
            return new ErrorsPayloadWithList(ex.getMessage(), LocalDateTime.now());
        } else {
            return new ErrorsPayloads(ex.getMessage(), LocalDateTime.now());
        }

    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorsPayloads handleUnauthorized(UnauthorizedException ex) {
        ex.printStackTrace();
        return new ErrorsPayloads(ex.getMessage(), LocalDateTime.now());
    }

//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ErrorsPayloads handleAccessDenied(AccessDeniedException ex) {
//        ex.printStackTrace();
//
//        return new ErrorsPayloads("Non hai l'accesso a questo endpoint", LocalDateTime.now());
//    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayloads handleNotFound(NotFoundException ex) {
        return new ErrorsPayloads(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayloads handleGenericErrors(Exception ex) {
        ex.printStackTrace();
        return new ErrorsPayloads("Problema lato server! Prometto che lo fixeremo presto!", LocalDateTime.now());
    }

}