package uz.pdp.apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apelsin.entity.Category;
import uz.pdp.apelsin.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAllByActiveTrue();

    Optional<Category> findAllByIdAndActiveTrue(Integer id);
}
