package az.akart.mspayments.dao.entity;

import static jakarta.persistence.EnumType.STRING;

import az.akart.mspayments.model.enums.TransactionDirection;
import az.akart.mspayments.model.enums.TransactionStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="transactions")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "customer_id")
  private Long customerId;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "direction")
  @Enumerated(value = STRING)
  private TransactionDirection direction;

  @Column(name = "status")
  @Enumerated(value = STRING)
  private TransactionStatus status;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Set<ReverseTransaction> reverseTransactions = new HashSet<>();

}
