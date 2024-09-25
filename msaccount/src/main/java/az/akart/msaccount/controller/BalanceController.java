package az.akart.msaccount.controller;

import az.akart.msaccount.model.AccountResponse;
import az.akart.msaccount.model.request.BalanceRequest;
import az.akart.msaccount.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
@RequiredArgsConstructor
public class BalanceController {

  private final BalanceService balanceService;

  @PostMapping("/debit")
  public AccountResponse debit(@RequestBody BalanceRequest request) {
    return balanceService.debit(request);
  }

  @PostMapping("/credit")
  public AccountResponse credit(@RequestBody BalanceRequest request) {
    return balanceService.credit(request);
  }

}
