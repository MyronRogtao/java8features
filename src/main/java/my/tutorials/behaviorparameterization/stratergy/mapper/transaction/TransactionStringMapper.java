package my.tutorials.behaviorparameterization.stratergy.mapper.transaction;

import my.tutorials.model.Transaction;

public class TransactionStringMapper implements TransactionMapper<String> {
    @Override
    public String map(Transaction transaction) {
        return transaction.toString();
    }
}
