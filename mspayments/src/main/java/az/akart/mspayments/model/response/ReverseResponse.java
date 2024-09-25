package az.akart.mspayments.model.response;

import az.akart.mspayments.model.enums.TransactionStatus;
import lombok.Builder;

@Builder
public record ReverseResponse(
    Long transactionId,
    Long reverseId,
    TransactionStatus status
) {
}
