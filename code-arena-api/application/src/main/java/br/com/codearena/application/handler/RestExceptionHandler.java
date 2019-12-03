package br.com.codearena.application.handler;

import br.com.codearena.application.handler.model.ErrorMessage;
import br.com.codearena.applicationservice.exception.contract.ApplicationException;
import br.com.codearena.domainservice.exception.contract.DomainException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleApplicationException(ApplicationException ex) {

        // FIXME: Adicionar um Logger
        ex.printStackTrace();

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(ex.getClass().getSimpleName());
        errorMessage.setCode(HttpStatus.BAD_REQUEST.name());
        errorMessage.setMessage(ex.getMessage());

        return errorMessage;
    }

    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleDomainException(DomainException ex) {

        // FIXME: Adicionar um Logger
        ex.printStackTrace();

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(ex.getClass().getSimpleName());
        errorMessage.setCode(HttpStatus.BAD_REQUEST.name());
        errorMessage.setMessage(ex.getMessage());

        return errorMessage;
    }

    @ExceptionHandler(PSQLException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handlePSQLException(PSQLException ex) {

        // FIXME: Adicionar um Logger
        ex.printStackTrace();

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(ex.getClass().getSimpleName());
        errorMessage.setCode(HttpStatus.BAD_REQUEST.name());
        errorMessage.setMessage("Unexpected error");

        return errorMessage;
    }

    @ExceptionHandler(DataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleDataException(DataException ex) {

        // FIXME: Adicionar um Logger
        ex.printStackTrace();

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(ex.getClass().getSimpleName());
        errorMessage.setCode(HttpStatus.BAD_REQUEST.name());
        errorMessage.setMessage("Unexpected error");

        return errorMessage;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleConstraintViolationException(ConstraintViolationException ex) {

        // FIXME: Adicionar um Logger
        ex.printStackTrace();

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(ex.getClass().getSimpleName());
        errorMessage.setCode(HttpStatus.BAD_REQUEST.name());
        errorMessage.setMessage("Unexpected error");

        return errorMessage;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handleAllExceptions(Exception ex) {

        // FIXME: Adicionar um Logger
        ex.printStackTrace();

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(ex.getClass().getSimpleName());
        errorMessage.setCode(HttpStatus.BAD_REQUEST.name());
        errorMessage.setMessage("Unexpected error");

        return errorMessage;
    }

}
