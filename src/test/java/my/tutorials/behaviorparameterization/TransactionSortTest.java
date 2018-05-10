package my.tutorials.behaviorparameterization;

import my.tutorials.behaviorparameterization.helper.TransactionHelper;
import my.tutorials.behaviorparameterization.stratergy.sort.transaction.SortBySourceAsc;
import my.tutorials.helper.DataHelper;
import my.tutorials.model.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TransactionSortTest {

    private List<Transaction> transactionList = new ArrayList<>();

    @Before
    public void init() {
        //Given : List of Transactions
        transactionList = DataHelper.initTransactions();
    }

    @Test
    public void sortBySourceAsc() {
        //When : Operation to sort the transactions by source in Asc order is performed
        List<Transaction> sortedList = TransactionHelper.sortTransactions(transactionList, new SortBySourceAsc());

        //Then : Transactions will be sorted by source in Asc order [Will provide assertions later]
        for(Transaction txn : sortedList) {
            System.out.println(txn);
        }
    }

    @Test
    public void sortByTypeAsc() {

    }

    @Test
    public void sortByAmountDesc() {

    }

    @Test
    public void sortByAmountAsc() {

    }
}
