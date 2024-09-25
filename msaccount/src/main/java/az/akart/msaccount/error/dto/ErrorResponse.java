package az.akart.msaccount.error.dto;

import az.akart.msaccount.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponse (
  Status status,
  String message
) {
}
