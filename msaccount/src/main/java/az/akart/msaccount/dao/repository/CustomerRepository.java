package az.akart.msaccount.dao.repository;

import az.akart.msaccount.dao.entity.Customer;
import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT c FROM Customer c WHERE c.id = :id")
  Optional<Customer> findByIdWithLock(Long id);

}
