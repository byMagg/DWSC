package dwsc.activity4swagger.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RepeatedExpection extends ResponseStatusException {

    private static final long serialVersionUID = -174467802521480650L;

    public RepeatedExpection(HttpStatus code, String message) {
        super(code, message);
    }

}