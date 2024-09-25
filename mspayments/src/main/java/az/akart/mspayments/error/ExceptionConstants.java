package az.akart.mspayments.error;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionConstants {

  public static final String CUSTOMER_NOT_FOUND = "CUSTOMER_NOT_FOUND";
  public static final String INSUFFICIENT_BALANCE = "INSUFFICIENT_BALANCE";
  public static final String FAILED_OPERATION = "FAILED_OPERATION";
  public static final String NO_SUCH_TRANSACTION = "NO_SUCH_TRANSACTION";
  public static final String REVERSAL_AMOUNT_EXCEEDS_ORIGINAL_AMOUNT = "REVERSAL_AMOUNT_EXCEEDS_ORIGINAL_AMOUNT";

}
