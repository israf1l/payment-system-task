package az.akart.mspayments.controller;

import az.akart.mspayments.service.PaymentsService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

  private final PaymentsService paymentsService;

  @PostMapping("/debit")
  public void debit() {
    paymentsService.debit(1L, new BigDecimal(100));
  }
  
}
