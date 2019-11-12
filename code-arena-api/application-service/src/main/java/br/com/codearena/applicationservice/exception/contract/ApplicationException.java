package br.com.codearena.applicationservice.exception.contract;

public abstract class ApplicationException extends RuntimeException {

    public ApplicationException() {
    }

    public ApplicationException(String s) {
        super(s);
    }

    public ApplicationException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ApplicationException(Throwable throwable) {
        super(throwable);
    }

}
