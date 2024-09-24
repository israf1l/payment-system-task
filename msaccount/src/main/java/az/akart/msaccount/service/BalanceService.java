package az.akart.msaccount.service;

import java.math.BigDecimal;

public interface BalanceService {

  void debit(Long customerId, BigDecimal amount);

  void credit(Long customerId, BigDecimal amount);

}
