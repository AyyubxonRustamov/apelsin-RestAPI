package uz.pdp.apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apelsin.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByActiveTrue();

    Optional<Product> findAllByIdAndActiveTrue(Integer id);
}
