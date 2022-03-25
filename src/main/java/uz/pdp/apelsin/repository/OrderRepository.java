package uz.pdp.apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apelsin.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
