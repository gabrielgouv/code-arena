package br.com.codearena.repository.contract;

import br.com.codearena.entity.contract.IBaseEntity;

import java.io.Serializable;
import java.util.List;

public interface IBaseRepository<T extends IBaseEntity, ID extends Serializable> {

    T save(T entity);

    void save(List<T> entities);

    void update(T entity);

    void update(List<T> entidades);

    void delete(T entity);

    void delete(ID id);

    void delete(List<T> entities);

    List<T> findAll();

    T findById(ID id);

}
