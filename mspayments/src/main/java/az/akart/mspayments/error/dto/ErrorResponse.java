package az.akart.mspayments.error.dto;

import az.akart.mspayments.model.enums.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse (
  TransactionStatus status,
  String message
) {
}
