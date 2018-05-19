package my.tutorials.behaviorparameterization.stratergy.mapper.transaction;

import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;

public class TransactionDetailsMapper implements TransactionMapper<TransactionDetails> {
    @Override
    public TransactionDetails map(Transaction transaction) {
        TransactionDetails details = new TransactionDetails();
        details.setType(transaction.getType().name());
        details.setPartiesInvolved(transaction.getSource() + ":"+ transaction.getDestination());
        details.setFormattedAmount("$"+ transaction.getAmount());
        return details;
    }
}
