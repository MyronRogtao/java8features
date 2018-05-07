package my.tutorials.behaviorparameterization.helper;

import my.tutorials.behaviorparameterization.model.Transaction;
import my.tutorials.behaviorparameterization.model.TxnType;
import my.tutorials.behaviorparameterization.stratergy.filter.transaction.TransactionPredicate;

import java.util.ArrayList;
import java.util.List;

public class TransactionHelper {

    private TransactionHelper(){}

    public static List<Transaction> findTransactionsGreaterThan2000(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getAmount() > 2000d) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public static List<Transaction> findTransactionsGreaterThan3000(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getAmount() > 3000d) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public static List<Transaction> findTransactionsGreaterThanGivenAmount(List<Transaction> transactions, Double amount) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getAmount() > amount) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public static List<Transaction> findTransactionsGreaterThanGivenAmountOfTypeCreditCarriedOutByX(
            List<Transaction> transactions,
            Double amount) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getAmount() > amount
                    && TxnType.CREDIT.equals(transaction.getType())
                    && transaction.getSource().equalsIgnoreCase("X")) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    //Lets do code reuse - Code to iterate and add to the final list will be common. Only pass the filter condition.
    public static List<Transaction> filterTransactionByPredicate(List<Transaction> transactions, TransactionPredicate predicate) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(predicate.filter(transaction)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }
}
