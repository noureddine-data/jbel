package org.example.library.jbel.repository;

//import com.example.registrationlogindemo.entity.User;
import org.example.library.jbel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
