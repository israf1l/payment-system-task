package az.akart.mspayments.utils;

import az.akart.mspayments.dao.entity.ReverseTransaction;
import az.akart.mspayments.dao.entity.Transaction;
import az.akart.mspayments.error.exceptions.ReversalAmountExceedsException;
import java.math.BigDecimal;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransactionUtils {

  public BigDecimal calculateRemainingAmount(Transaction transaction, List<ReverseTransaction> reverseTransactions) {
    BigDecimal totalReversedAmount = reverseTransactions.stream()
        .map(ReverseTransaction::getAmount)
        .reduce(BigDecimal.ZERO, BigDecimal::add);

    return transaction.getAmount().subtract(totalReversedAmount);
  }

  public BigDecimal calculateAmountToReverse(BigDecimal requestAmount, BigDecimal remainingAmountToReverse) {
    BigDecimal amountToReverse = requestAmount != null ? requestAmount : remainingAmountToReverse;

    if (amountToReverse.compareTo(remainingAmountToReverse) > 0) {
      throw new ReversalAmountExceedsException();
    }

    return amountToReverse;
  }

}
