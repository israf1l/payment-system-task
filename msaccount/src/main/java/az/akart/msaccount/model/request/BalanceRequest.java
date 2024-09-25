package az.akart.msaccount.model.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record BalanceRequest(
    @NotNull
    Long customerId,

    @NotNull
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero.")
    BigDecimal amount
) {
}
