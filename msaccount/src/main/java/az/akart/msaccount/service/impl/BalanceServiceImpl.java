package az.akart.msaccount.service.impl;

import az.akart.msaccount.dao.entity.Customer;
import az.akart.msaccount.dao.repository.CustomerRepository;
import az.akart.msaccount.error.exceptions.CustomerNotFoundException;
import az.akart.msaccount.error.exceptions.InsufficientBalanceException;
import az.akart.msaccount.model.AccountResponse;
import az.akart.msaccount.model.enums.Status;
import az.akart.msaccount.model.request.BalanceRequest;
import az.akart.msaccount.service.BalanceService;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

  private final CustomerRepository customerRepository;

  @Override
  @Transactional
  public AccountResponse debit(BalanceRequest request) {
    Customer customer = customerRepository.findByIdWithLock(request.customerId())
        .orElseThrow(() -> new CustomerNotFoundException(request.customerId()));

    BigDecimal newBalance = customer.getBalance().subtract(request.amount());

    if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
      throw new InsufficientBalanceException(request.customerId());
    }

    customer.setBalance(newBalance);

    log.info("Debited {} to customer {}. New balance: {}", request.amount(), customer.getId(), newBalance);

    return AccountResponse.builder()
        .status(Status.SUCCESS)
        .build();
  }

  @Override
  @Transactional
  public AccountResponse credit(BalanceRequest request) {
    Customer customer = customerRepository.findByIdWithLock(request.customerId())
        .orElseThrow(() -> new CustomerNotFoundException(request.customerId()));

    BigDecimal newBalance = customer.getBalance().add(request.amount());
    customer.setBalance(newBalance);

    log.info("Credited {} to customer {}. New balance: {}", request.amount(), customer.getId(), newBalance);

    return AccountResponse.builder()
        .status(Status.SUCCESS)
        .build();
  }

}
