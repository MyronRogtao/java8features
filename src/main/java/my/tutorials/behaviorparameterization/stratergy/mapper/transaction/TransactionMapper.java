package my.tutorials.behaviorparameterization.stratergy.mapper.transaction;

import my.tutorials.model.Transaction;

public interface TransactionMapper<R> {

    R map(Transaction transaction);
}
