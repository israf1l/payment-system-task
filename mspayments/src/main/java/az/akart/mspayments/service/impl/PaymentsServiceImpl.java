package az.akart.mspayments.service.impl;

import static az.akart.mspayments.model.enums.TransactionDirection.CREDIT;
import static az.akart.mspayments.model.enums.TransactionDirection.DEBIT;
import static az.akart.mspayments.model.enums.TransactionStatus.SUCCESS;

import az.akart.mspayments.client.AccountClient;
import az.akart.mspayments.client.model.response.AccountResponse;
import az.akart.mspayments.dao.entity.Transaction;
import az.akart.mspayments.error.exceptions.FailedOperationException;
import az.akart.mspayments.model.request.PaymentRequest;
import az.akart.mspayments.model.request.ReverseRequest;
import az.akart.mspayments.model.response.PaymentResponse;
import az.akart.mspayments.model.response.ReverseResponse;
import az.akart.mspayments.service.PaymentsService;
import az.akart.mspayments.service.TransactionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentsServiceImpl implements PaymentsService {

  private final AccountClient accountClient;
  private final TransactionService transactionService;

  @Override
  public PaymentResponse debit(PaymentRequest request) {
    AccountResponse accountResponse = accountClient.debit(request);

    if (accountResponse.status() == SUCCESS) {
      Transaction transaction = transactionService.saveTransaction(request, DEBIT);

      return PaymentResponse.builder()
          .transactionId(transaction.getId())
          .build();
    }
    throw new FailedOperationException();
  }

  @Override
  public PaymentResponse credit(PaymentRequest request) {
    AccountResponse accountResponse = accountClient.credit(request);

    if (accountResponse.status() == SUCCESS) {
      Transaction transaction = transactionService.saveTransaction(request, CREDIT);

      return PaymentResponse.builder()
          .transactionId(transaction.getId())
          .build();
    }
    throw new FailedOperationException();
  }

  @Override
  @Transactional
  public ReverseResponse reverse(ReverseRequest request) {
    Transaction transaction = transactionService.reverseTransaction(request);

    AccountResponse accountResponse = accountClient.credit(PaymentRequest.builder()
            .customerId(transaction.getCustomerId())
            .amount(request.amount() != null ? request.amount() : transaction.getAmount())
        .build());

    if (accountResponse.status() == SUCCESS) {
      return ReverseResponse.builder()
          .transactionId(transaction.getId())
          .build();
    }
    throw new FailedOperationException();
  }

}
