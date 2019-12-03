package br.com.codearena.domain.entity;

import br.com.codearena.domain.entity.contract.BaseEntity;
import br.com.codearena.domain.enumeration.DifficultLevel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "challenges")
@SequenceGenerator(name  = BaseEntity.SEQUENCE_GENERATOR_NAME, sequenceName = "seq_challenges", allocationSize = 1)
public class Challenge extends BaseEntity<Long> {

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "text", nullable = false)
    private String content;

    @Column(name = "input_format", columnDefinition = "text", nullable = false)
    private String inputFormat;

    @Column(name = "constraints", columnDefinition = "text", nullable = false)
    private String constraints;

    @Column(name = "output_format", columnDefinition = "text", nullable = false)
    private String outputFormat;

    @Column(name = "test_cases", columnDefinition = "text", nullable = false)
    private String testCases;

    @Column(name = "test_expectation", columnDefinition = "text", nullable = false)
    private String testExpectation;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficult_level", nullable = false)
    private DifficultLevel difficultLevel;

    @Column
    private Float rating;

    @ManyToMany(mappedBy = "favoriteChallenges")
    private List<User> usersWhoFavorited;

    @ManyToMany(mappedBy = "solvedChallenges")
    private List<User> usersWhoSolved;

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

    public String getInputFormat() {
        return inputFormat;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public String getConstraints() {
        return constraints;
    }

    public void setConstraints(String constraints) {
        this.constraints = constraints;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public String getTestCases() {
        return testCases;
    }

    public void setTestCases(String testCases) {
        this.testCases = testCases;
    }

    public String getTestExpectation() {
        return testExpectation;
    }

    public void setTestExpectation(String testExpectation) {
        this.testExpectation = testExpectation;
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

    public List<User> getUsersWhoFavorited() {
        return usersWhoFavorited;
    }

    public void setUsersWhoFavorited(List<User> usersWhoFavorited) {
        this.usersWhoFavorited = usersWhoFavorited;
    }

    public List<User> getUsersWhoSolved() {
        return usersWhoSolved;
    }

    public void setUsersWhoSolved(List<User> usersWhoSolved) {
        this.usersWhoSolved = usersWhoSolved;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
