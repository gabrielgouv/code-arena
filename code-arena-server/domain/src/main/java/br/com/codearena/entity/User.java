package br.com.codearena.entity;

import br.com.codearena.entity.contract.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity<Long> {

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany
    private List<Challenge> favoriteChallenges;

    @OneToMany(mappedBy = "author")
    private List<Challenge> createdChallenges;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Challenge> getFavoriteChallenges() {
        return favoriteChallenges;
    }

    public void setFavoriteChallenges(List<Challenge> favoriteChallenges) {
        this.favoriteChallenges = favoriteChallenges;
    }

    public List<Challenge> getCreatedChallenges() {
        return createdChallenges;
    }

    public void setCreatedChallenges(List<Challenge> createdChallenges) {
        this.createdChallenges = createdChallenges;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
