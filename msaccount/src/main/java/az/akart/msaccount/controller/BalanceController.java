package az.akart.msaccount.controller;

import az.akart.msaccount.service.BalanceService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class BalanceController {

  private final BalanceService balanceService;

  @PostMapping("/debit")
  public void debit() {
    balanceService.debit(1L, new BigDecimal(100));
  }

}
