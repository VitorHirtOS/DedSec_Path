package dedsec.projeto_dedsec.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByName(String name);
    Optional<UserModel> findAllByPassword(String password);
}
