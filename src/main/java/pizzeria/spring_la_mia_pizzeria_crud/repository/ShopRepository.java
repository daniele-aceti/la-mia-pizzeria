package pizzeria.spring_la_mia_pizzeria_crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pizzeria.spring_la_mia_pizzeria_crud.model.Shop;


public interface ShopRepository extends JpaRepository<Shop, Long> {

    Optional<Shop> findById(Long id);

}
