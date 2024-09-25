package az.akart.mspayments.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
@Table(name ="reverse_transactions")
public class ReverseTransaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "amount")
  private BigDecimal amount;

  @CreationTimestamp
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "transaction_id", nullable = false)
  private Transaction transaction;

}
