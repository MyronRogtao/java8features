package my.tutorials.behaviorparameterization.stratergy.filter.transaction;

import my.tutorials.model.Transaction;

public class FilterByAmount implements TransactionPredicate {

    @Override
    public boolean filter(Transaction transaction) {
        return transaction.getAmount()>2000;
    }
}
