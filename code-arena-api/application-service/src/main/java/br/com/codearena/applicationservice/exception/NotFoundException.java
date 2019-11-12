package br.com.codearena.applicationservice.exception;

import br.com.codearena.applicationservice.exception.contract.ApplicationException;

public class NotFoundException extends ApplicationException {

    public NotFoundException() {
    }

    public NotFoundException(String s) {
        super(s);
    }

    public NotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotFoundException(Throwable throwable) {
        super(throwable);
    }

}
