package demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import demo.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
