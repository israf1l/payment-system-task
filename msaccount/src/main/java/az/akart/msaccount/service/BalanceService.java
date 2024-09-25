package az.akart.msaccount.service;

import az.akart.msaccount.model.request.BalanceRequest;

public interface BalanceService {

  void debit(BalanceRequest request);

  void credit(BalanceRequest request);

}
