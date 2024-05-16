package org.example.library.jbel.repository;

//import com.example.registrationlogindemo.entity.Role;
import org.example.library.jbel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
