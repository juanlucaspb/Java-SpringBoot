package jlucas.primeiro_projeto.exception;
import jlucas.primeiro_projeto.domain.entity.User;
import jlucas.primeiro_projeto.interfaces.controller.v1.exception.SemRetornoException;
import jlucas.primeiro_projeto.interfaces.output.APIResponseDTO;
import jlucas.primeiro_projeto.utils.Constantes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice

public class GlobalExceptionHandler
{
    @ExceptionHandler(SemRetornoException.class)
    public ResponseEntity<APIResponseDTO<User>> handleSemRetornoException(SemRetornoException exception)
    {
        APIResponseDTO<User> response = new APIResponseDTO();
        response.setStatus("Error");
        response.setMessage(exception.getMessage());
        return new ResponseEntity<APIResponseDTO<User>>(response,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<APIResponseDTO<User>> handleNumberFormatException(MethodArgumentTypeMismatchException exception)
    {
        APIResponseDTO<User> response = new APIResponseDTO();
        response.setStatus("Error");
        response.setMessage(Constantes.Erros.VALOR_INVALIDO);
        return new ResponseEntity<APIResponseDTO<User>>(response,HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponseDTO<User>> handleException(Exception exception)
    {
        APIResponseDTO<User> response = new APIResponseDTO();
        response.setStatus("Error");
        exception.printStackTrace();
        response.setMessage(Constantes.Erros.FALHA_NAO_PREVISTA);
        return new ResponseEntity<APIResponseDTO<User>>(response,HttpStatus.SERVICE_UNAVAILABLE);

    }
}
