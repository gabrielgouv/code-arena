package br.com.codearena.domainservice.exception.contract;

public abstract class DomainException extends RuntimeException {

    public DomainException() {
    }

    public DomainException(String s) {
        super(s);
    }

    public DomainException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public DomainException(Throwable throwable) {
        super(throwable);
    }

}
