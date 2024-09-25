package az.akart.mspayments.dao.repository;

import az.akart.mspayments.dao.entity.Transaction;
import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT c FROM Transaction c WHERE c.id = :id")
  Optional<Transaction> findByIdWithLock(Long id);

}
