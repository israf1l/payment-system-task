package az.akart.mspayments.service;

import az.akart.mspayments.dao.entity.Transaction;
import az.akart.mspayments.model.dto.ReverseDto;
import az.akart.mspayments.model.enums.TransactionDirection;
import az.akart.mspayments.model.request.PaymentRequest;
import az.akart.mspayments.model.request.ReverseRequest;

public interface TransactionService {

  Transaction saveTransaction(PaymentRequest request, TransactionDirection direction);

  ReverseDto reverseTransaction(ReverseRequest reverseRequest);

}
