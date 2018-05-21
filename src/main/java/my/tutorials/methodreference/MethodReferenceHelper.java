package my.tutorials.methodreference;

import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;
import my.tutorials.model.TxnType;

public class MethodReferenceHelper {

    public <T> void print(T object) {
        System.out.println(object.toString());
    }

    public static <T> void printData(T object) {
        System.out.println(object.toString());
    }

    public boolean validateTransaction(Transaction transaction) {
        if (transaction.getAmount() < 40000d) {
            return true;
        }

        if (transaction.getAmount() > 200d && TxnType.CREDIT.equals(transaction.getType())) {
            return true;
        }
        return false;
    }

    public static boolean validateTxn(Transaction transaction) {
        if (transaction.getAmount() < 40000d) {
            return true;
        }

        if (transaction.getAmount() > 200d && TxnType.CREDIT.equals(transaction.getType())) {
            return true;
        }
        return false;
    }

    public TransactionDetails mapTransaction(Transaction transaction) {
        TransactionDetails details = new TransactionDetails();
        details.setFormattedAmount("$" + transaction.getAmount());
        details.setPartiesInvolved(transaction.getSource()+":"+transaction.getDestination());
        details.setType(transaction.getType().name());
        return details;
    }

    public static TransactionDetails mapTransactionDetails(Transaction transaction) {
        TransactionDetails details = new TransactionDetails();
        details.setFormattedAmount("$" + transaction.getAmount());
        details.setPartiesInvolved(transaction.getSource()+":"+transaction.getDestination());
        details.setType(transaction.getType().name());
        return details;
    }



    public TransactionDetails mapTransaction(Transaction transaction, String currencyFormat) {
        TransactionDetails details = new TransactionDetails();
        details.setFormattedAmount(currencyFormat + transaction.getAmount());
        details.setPartiesInvolved(transaction.getSource()+":"+transaction.getDestination());
        details.setType(transaction.getType().name());
        return details;
    }

    public static TransactionDetails mapTransactionDetails(Transaction transaction, String currencyFormat) {
        TransactionDetails details = new TransactionDetails();
        details.setFormattedAmount(currencyFormat + transaction.getAmount());
        details.setPartiesInvolved(transaction.getSource()+":"+transaction.getDestination());
        details.setType(transaction.getType().name());
        return details;
    }
}
