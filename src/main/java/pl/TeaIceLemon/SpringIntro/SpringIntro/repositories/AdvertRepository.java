package pl.TeaIceLemon.SpringIntro.SpringIntro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.Advert;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, Long> {
    List<Advert> findAllByOrderByPostedDesc();

}
