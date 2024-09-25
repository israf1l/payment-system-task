package az.akart.mspayments.model.dto;

import az.akart.mspayments.dao.entity.ReverseTransaction;
import az.akart.mspayments.dao.entity.Transaction;
import lombok.Builder;

@Builder
public record ReverseDto(
    Transaction transaction,
    ReverseTransaction reverseTransaction
) {
}
