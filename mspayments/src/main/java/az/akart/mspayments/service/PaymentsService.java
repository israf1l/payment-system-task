package az.akart.mspayments.service;

import az.akart.mspayments.model.request.PaymentRequest;
import az.akart.mspayments.model.request.ReverseRequest;
import az.akart.mspayments.model.response.PaymentResponse;
import az.akart.mspayments.model.response.ReverseResponse;

public interface PaymentsService {

  PaymentResponse debit(PaymentRequest request);

  PaymentResponse credit(PaymentRequest request);

  ReverseResponse reverse(ReverseRequest request);

}
