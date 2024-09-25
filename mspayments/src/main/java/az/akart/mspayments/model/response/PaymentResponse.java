package az.akart.mspayments.model.response;

import az.akart.mspayments.model.enums.TransactionStatus;
import lombok.Builder;

@Builder
public record PaymentResponse(
    Long transactionId,
    TransactionStatus status
) {
}
