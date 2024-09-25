package az.akart.mspayments.model.request;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ReverseRequest(
    @NotNull
    Long transactionId,
    BigDecimal amount
) {
}
