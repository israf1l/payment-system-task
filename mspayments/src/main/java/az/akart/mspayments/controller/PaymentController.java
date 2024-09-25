package az.akart.mspayments.controller;

import az.akart.mspayments.model.request.PaymentRequest;
import az.akart.mspayments.model.request.ReverseRequest;
import az.akart.mspayments.model.response.PaymentResponse;
import az.akart.mspayments.service.PaymentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

  private final PaymentsService paymentsService;


  @PostMapping("/debit")
  public PaymentResponse debit(@RequestBody PaymentRequest request) {
    return paymentsService.debit(request);
  }

  @PostMapping("/credit")
  public PaymentResponse credit(@RequestBody PaymentRequest request) {
    return paymentsService.credit(request);
  }

  @PostMapping("/reverse")
  public void reverse(@RequestBody ReverseRequest request) {
    return paymentsService.reverse(request);
  }
  
}
