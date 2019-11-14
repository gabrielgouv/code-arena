package br.com.codearena.application.handler;

import br.com.codearena.application.handler.model.ErrorMessage;
import br.com.codearena.applicationservice.exception.contract.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    private static final String APPLICATION_EXCEPTION = "APPLICATION_EXCEPTION";

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleBaseException(ApplicationException ex) {

        // FIXME: Adicionar um Logger
        ex.printStackTrace();

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(APPLICATION_EXCEPTION);
        errorMessage.setCode(HttpStatus.BAD_REQUEST.name());
        errorMessage.setMessage(ex.getMessage());

        return errorMessage;

    }

}
