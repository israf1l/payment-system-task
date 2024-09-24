package az.akart.mspayments.dao.entity;

import static jakarta.persistence.EnumType.STRING;

import az.akart.mspayments.model.enums.TransactionDirection;
import az.akart.mspayments.model.enums.TransactionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name ="transactions")
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private Long userId;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "direction")
  @Enumerated(value = STRING)
  private TransactionDirection direction;

  @Column(name = "status")
  @Enumerated(value = STRING)
  private TransactionStatus status;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

}
