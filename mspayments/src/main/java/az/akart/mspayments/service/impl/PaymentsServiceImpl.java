package az.akart.mspayments.service.impl;

import az.akart.mspayments.service.PaymentsService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentsServiceImpl implements PaymentsService {


  @Override
  public void topUp(Long customerId, BigDecimal amount) {

  }

  @Override
  public void credit(Long customerId, BigDecimal amount) {

  }

}
