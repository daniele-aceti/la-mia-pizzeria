package pizzeria.spring_la_mia_pizzeria_crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzeria.spring_la_mia_pizzeria_crud.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findById(Long id);

    Optional<Role> findByName(String name);

}
