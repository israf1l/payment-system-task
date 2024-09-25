package az.akart.msaccount.service;

import az.akart.msaccount.model.AccountResponse;
import az.akart.msaccount.model.request.BalanceRequest;

public interface BalanceService {

  AccountResponse debit(BalanceRequest request);

  AccountResponse credit(BalanceRequest request);

}
