package pl.TeaIceLemon.SpringIntro.SpringIntro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
