package az.akart.msaccount.model;

import az.akart.msaccount.model.enums.Status;
import lombok.Builder;

@Builder
public record AccountResponse(
    Status status
) {
}
