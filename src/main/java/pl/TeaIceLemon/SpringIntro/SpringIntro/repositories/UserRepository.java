package pl.TeaIceLemon.SpringIntro.SpringIntro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.TeaIceLemon.SpringIntro.SpringIntro.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
