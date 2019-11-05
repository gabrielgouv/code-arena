package br.com.codearena.entity.contract;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private T id;

    @Column
    private LocalDateTime deletion;

    @Column
    private LocalDateTime creation;

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

    public LocalDateTime getCreation() {
        return creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }

}
