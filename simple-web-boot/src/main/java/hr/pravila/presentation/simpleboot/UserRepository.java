package hr.pravila.presentation.simpleboot;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author stjep
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdentificationNumber(String identificationNumber);
}
