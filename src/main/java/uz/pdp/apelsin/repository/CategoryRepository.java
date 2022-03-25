package uz.pdp.apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apelsin.entity.Category;
import uz.pdp.apelsin.entity.Customer;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findAllByActiveTrue();
}
