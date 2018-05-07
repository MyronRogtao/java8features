package my.tutorials.behaviorparameterization.stratergy.filter.transaction;

import my.tutorials.behaviorparameterization.model.Transaction;
import my.tutorials.behaviorparameterization.model.TxnType;
import my.tutorials.behaviorparameterization.stratergy.filter.transaction.TransactionPredicate;

public class FilterByAmountCreditAndSource implements TransactionPredicate {

    @Override
    public boolean filter(Transaction transaction) {
        return transaction.getAmount() > 2000
                && TxnType.CREDIT.equals(transaction.getType())
                && transaction.getSource().equalsIgnoreCase("X");
    }
}
