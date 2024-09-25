package az.akart.mspayments.model.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Builder;

@Builder
public record PaymentRequest (
    @NotNull
    Long customerId,

    @NotNull
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero.")
    BigDecimal amount
) {
}
