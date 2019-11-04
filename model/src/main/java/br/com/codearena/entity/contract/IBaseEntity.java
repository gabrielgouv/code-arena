package br.com.codearena.entity.contract;

import java.time.LocalDateTime;

public class IBaseEntity<T> {

    private T id;
    private LocalDateTime deletion;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public LocalDateTime getDeletion() {
        return deletion;
    }

    public void setDeletion(LocalDateTime deletion) {
        this.deletion = deletion;
    }

}
