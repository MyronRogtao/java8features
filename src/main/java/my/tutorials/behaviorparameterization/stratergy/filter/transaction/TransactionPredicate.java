package my.tutorials.behaviorparameterization.stratergy.filter.transaction;

import my.tutorials.behaviorparameterization.model.Transaction;

public interface TransactionPredicate {

    boolean filter(Transaction transaction);
}
