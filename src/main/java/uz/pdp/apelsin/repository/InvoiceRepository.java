package uz.pdp.apelsin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.apelsin.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
