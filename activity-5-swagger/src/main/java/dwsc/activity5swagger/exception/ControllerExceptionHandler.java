package dwsc.activity5swagger.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<CustomResponse> userNotFound(RuntimeException ex) {
        CustomResponse resp = new CustomResponse();
        resp.setTimestamp(LocalDateTime.now());
        resp.setError(ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
    }
}