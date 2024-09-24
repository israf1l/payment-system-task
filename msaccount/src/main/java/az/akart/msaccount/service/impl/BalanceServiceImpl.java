package az.akart.msaccount.service.impl;

import az.akart.msaccount.dao.entity.Customer;
import az.akart.msaccount.dao.repository.CustomerRepository;
import az.akart.msaccount.service.BalanceService;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

  private final CustomerRepository customerRepository;

  @Override
  public void debit(Long customerId, BigDecimal amount) {
    Optional<Customer> optionCustomer = customerRepository.findById(customerId);

    if (optionCustomer.isEmpty()) {
      return;
    }

    Customer customer = optionCustomer.get();
    customer.setBalance(customer.getBalance().add(amount));
    customerRepository.save(customer);
  }

  @Override
  public void credit(Long customerId, BigDecimal amount) {
    Optional<Customer> optionCustomer = customerRepository.findById(customerId);
    if (optionCustomer.isEmpty()) {
      return;
    }
    Customer customer = optionCustomer.get();
    customer.setBalance(customer.getBalance().subtract(amount));
    customerRepository.save(customer);
  }

}
