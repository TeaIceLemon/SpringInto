package pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    @Column(unique = true, nullable = false)
     private String username;
    @Column(nullable = false)
     private String password;
    @Column(name = "first_name", nullable = false)
     private String firstName;
    @Column(name = "last_name", nullable = false)
     private String lastName;
    @Column(nullable = false)
     private boolean active;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return active == user.active &&
                Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, firstName, lastName, active);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", active=" + active +
                '}';
    }
}
