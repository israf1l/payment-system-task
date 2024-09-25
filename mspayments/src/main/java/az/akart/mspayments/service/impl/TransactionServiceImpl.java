package az.akart.mspayments.service.impl;

import az.akart.mspayments.dao.entity.ReverseTransaction;
import az.akart.mspayments.dao.entity.Transaction;
import az.akart.mspayments.dao.repository.TransactionRepository;
import az.akart.mspayments.error.exceptions.NoSuchTransactionException;
import az.akart.mspayments.model.enums.TransactionDirection;
import az.akart.mspayments.model.enums.TransactionStatus;
import az.akart.mspayments.model.request.PaymentRequest;
import az.akart.mspayments.model.request.ReverseRequest;
import az.akart.mspayments.service.TransactionService;
import az.akart.mspayments.utils.TransactionUtils;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  public Transaction saveTransaction(PaymentRequest request, TransactionDirection direction) {
    return transactionRepository.save(Transaction.builder()
        .customerId(request.customerId())
        .amount(request.amount())
        .direction(direction)
        .status(TransactionStatus.SUCCESS)
        .build());
  }

  public Transaction reverseTransaction(ReverseRequest reverseRequest) {
    Transaction transaction = findTransactionById(reverseRequest.transactionId());

    BigDecimal remainingAmount = TransactionUtils.calculateRemainingAmount(transaction);

    BigDecimal amountToReverse =
        TransactionUtils.calculateAmountToReverse(reverseRequest.amount(), remainingAmount);

    ReverseTransaction reverseTransaction = createReverseTransaction(transaction, amountToReverse);

    updateTransactionStatus(transaction, TransactionStatus.REVERSE);

    return transaction;
  }

  private Transaction findTransactionById(Long transactionId) {
    return transactionRepository.findById(transactionId)
        .orElseThrow(NoSuchTransactionException::new);
  }

  private ReverseTransaction createReverseTransaction(Transaction transaction, BigDecimal amount) {
    ReverseTransaction reverseTransaction = new ReverseTransaction();
    reverseTransaction.setTransaction(transaction);
    reverseTransaction.setAmount(amount);
    reverseTransaction.setCreatedAt(LocalDateTime.now());
    return reverseTransaction;
  }

  private void updateTransactionStatus(Transaction transaction, TransactionStatus status) {
    transaction.setStatus(status);
    transactionRepository.save(transaction);
  }

}
