package br.com.codearena.contract;

import br.com.codearena.entity.contract.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface IJpaBaseRepository<T extends BaseEntity, ID extends Serializable> extends JpaRepository<T, ID> {

}
