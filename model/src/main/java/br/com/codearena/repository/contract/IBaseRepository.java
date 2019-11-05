package br.com.codearena.repository.contract;

import br.com.codearena.entity.contract.BaseEntity;

import java.io.Serializable;

public interface IBaseRepository<T extends BaseEntity, ID extends Serializable> {

}
