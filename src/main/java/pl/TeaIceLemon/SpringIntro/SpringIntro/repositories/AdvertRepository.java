package pl.TeaIceLemon.SpringIntro.SpringIntro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.Advert;

public interface AdvertRepository extends JpaRepository<Advert, Long> {
}
