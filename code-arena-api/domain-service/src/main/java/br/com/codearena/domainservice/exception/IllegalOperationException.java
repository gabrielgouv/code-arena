package br.com.codearena.domainservice.exception;

import br.com.codearena.domainservice.exception.contract.DomainException;

public class IllegalOperationException extends DomainException {

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
