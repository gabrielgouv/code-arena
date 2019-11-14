package br.com.codearena.applicationservice.exception;

import br.com.codearena.applicationservice.exception.contract.ApplicationException;

public class IllegalOperationException extends ApplicationException {

    public IllegalOperationException() {
    }

    public IllegalOperationException(String s) {
        super(s);
    }

    public IllegalOperationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public IllegalOperationException(Throwable throwable) {
        super(throwable);
    }

}
