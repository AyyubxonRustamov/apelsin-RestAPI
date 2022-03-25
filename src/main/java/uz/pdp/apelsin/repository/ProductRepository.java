package uz.pdp.apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apelsin.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
