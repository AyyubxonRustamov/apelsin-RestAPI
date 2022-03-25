package uz.pdp.apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apelsin.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
