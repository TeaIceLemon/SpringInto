package pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "adverts")
@Getter @Setter
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;
    private LocalDateTime posted;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @Column(name = "owner_id")
    private Long owner_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return id == advert.id &&
                Objects.equals(owner_id, advert.owner_id);
}

    @Override
    public int hashCode() {
        return Objects.hash(id,owner_id);
    }

    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", posted=" + posted +
                ", owner=" + owner +
                ", owner_id=" + owner_id +
                '}';
    }
}
