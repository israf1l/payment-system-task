package az.akart.mspayments.dao.repository;

import az.akart.mspayments.dao.entity.ReverseTransaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReverseTransactionRepository extends JpaRepository<ReverseTransaction, Long> {

  List<ReverseTransaction> findByTransactionId(Long transactionId);

}
