package az.akart.msaccount.controller;

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
  public void debit(@RequestBody BalanceRequest request) {
    balanceService.debit(request);
  }

  @PostMapping("/credit")
  public void credit(@RequestBody BalanceRequest request) {
    balanceService.credit(request);
  }

}
