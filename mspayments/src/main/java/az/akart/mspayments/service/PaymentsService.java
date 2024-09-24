package az.akart.mspayments.service;

import java.math.BigDecimal;

public interface PaymentsService {

  void topUp(Long customerId, BigDecimal amount);

  void credit(Long customerId, BigDecimal amount);

}
