package location.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class LocationExeption extends ResponseEntityExceptionHandler {

        @ExceptionHandler(AddressNotFoundException.class)
        public ResponseEntity<Object> addressNotFoundException(AddressNotFoundException e, WebRequest request){
            Map<String, Object> body = new LinkedHashMap<>();
            body.put("message", e.getMessage());

            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        }
}
