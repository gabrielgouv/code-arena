package br.com.codearena.entity;

import br.com.codearena.entity.contract.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favorite_challenges")
public class FavoriteChallenge extends BaseEntity<Long> {

    @ManyToOne
    private User user;

    @ManyToOne
    private Challenge challenge;

}
