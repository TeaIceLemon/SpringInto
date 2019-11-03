package pl.TeaIceLemon.SpringIntro.SpringIntro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.Advert;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.User;

import java.util.List;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {
    List<Advert> findAllByOrderByPostedDesc();
    List<Advert> findAllByOwner(User user);

}
