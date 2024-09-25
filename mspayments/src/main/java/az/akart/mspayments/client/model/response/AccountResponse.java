package az.akart.mspayments.client.model.response;

import az.akart.mspayments.model.enums.TransactionStatus;

public record AccountResponse(
    TransactionStatus status
) {
}
