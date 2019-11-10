package br.com.codearena.domain.entity;

import br.com.codearena.domain.entity.contract.BaseEntity;
import br.com.codearena.domain.enumeration.DifficultLevel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "challenges")
public class Challenge extends BaseEntity<Long> {

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficult_level", nullable = false)
    private DifficultLevel difficultLevel;

    @Column
    private Float rating;

    @ManyToMany(mappedBy = "favoriteChallenges")
    private List<User> usersWhoFavorited;

    @ManyToOne
    private User author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DifficultLevel getDifficultLevel() {
        return difficultLevel;
    }

    public void setDifficultLevel(DifficultLevel difficultLevel) {
        this.difficultLevel = difficultLevel;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<User> getUsersWhoFavorited() {
        return usersWhoFavorited;
    }

    public void setUsersWhoFavorited(List<User> usersWhoFavorited) {
        this.usersWhoFavorited = usersWhoFavorited;
    }
}
