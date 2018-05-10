package my.tutorials.behaviorparameterization.stratergy.sort.transaction;

import my.tutorials.model.Transaction;

import java.util.Comparator;

/**
 * Comparator to sort transactions by source in ASC order
 */
public class SortBySourceAsc implements Comparator<Transaction> {

    @Override
    public int compare(Transaction txn1, Transaction txn2) {
        if(txn1.getSource() == null) {
            return -1;
        }
        return txn1.getSource().compareTo(txn2.getSource());
    }
}
