package br.com.codearena.domain.entity;

import br.com.codearena.domain.entity.contract.BaseEntity;
import br.com.codearena.domain.enumeration.UserRole;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity<Long> {

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 30)
    private String password;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @ManyToMany
    private List<Challenge> favoriteChallenges;

    @OneToMany(mappedBy = "author")
    private List<Challenge> createdChallenges;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false, columnDefinition = "varchar(32) default 'USER'")
    private UserRole role = UserRole.USER;

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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}