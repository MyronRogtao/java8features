package my.tutorials.behaviorparameterization;

import my.tutorials.behaviorparameterization.helper.TransactionHelper;
import my.tutorials.behaviorparameterization.stratergy.sort.transaction.SortBySourceAsc;
import my.tutorials.helper.DataHelper;
import my.tutorials.model.Transaction;
import my.tutorials.model.TxnType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

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

        //Then : Transactions will be sorted by source in Asc order
        assertThat(sortedList.size(), equalTo(10));
        assertThat(sortedList.get(0).getSource(), equalTo("A"));
        assertThat(sortedList.get(sortedList.size()-1).getSource(), equalTo("Z"));
    }

    @Test
    public void sortByTypeAsc() {
        Comparator<Transaction> sortByTypeAscComparator = new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return t1.getType().compareTo(t2.getType());
            }
        };

        //When : Operation to sort the transactions by Type in Asc order is performed
        List<Transaction> sortedList = TransactionHelper.sortTransactions(transactionList, sortByTypeAscComparator);

        //Then : Transactions will be sorted by Type in Asc order
        assertThat(sortedList.size(), equalTo(10));
        assertThat(sortedList.get(0).getType(), equalTo(TxnType.CREDIT));
        assertThat(sortedList.get(1).getType(), equalTo(TxnType.CREDIT));
        assertThat(sortedList.get(2).getType(), equalTo(TxnType.CREDIT));
        assertThat(sortedList.get(3).getType(), equalTo(TxnType.CREDIT));
        assertThat(sortedList.get(4).getType(), equalTo(TxnType.CREDIT));
        assertThat(sortedList.get(5).getType(), equalTo(TxnType.CREDIT));
        assertThat(sortedList.get(6).getType(), equalTo(TxnType.DEBIT));
        assertThat(sortedList.get(7).getType(), equalTo(TxnType.DEBIT));
        assertThat(sortedList.get(8).getType(), equalTo(TxnType.DEBIT));
        assertThat(sortedList.get(9).getType(), equalTo(TxnType.DEBIT));
    }

    @Test
    public void sortByAmountDesc() {

        Comparator<Transaction> sortByAmountDescComparator = new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return (-1) * t1.getAmount().compareTo(t2.getAmount());
            }
        };

        //When : Operation to sort the transactions by Amount in Desc order is performed
        List<Transaction> sortedList = TransactionHelper.sortTransactions(transactionList, sortByAmountDescComparator);

        //Then : Transactions will be sorted by Amount in Desc order
        assertThat(sortedList.size(), equalTo(10));
        assertThat(sortedList.get(0).getAmount(), equalTo(50000d));
        assertThat(sortedList.get(1).getAmount(), equalTo(40000d));
        assertThat(sortedList.get(2).getAmount(), equalTo(30000d));
        assertThat(sortedList.get(3).getAmount(), equalTo(22000d));
        assertThat(sortedList.get(4).getAmount(), equalTo(10000d));
        assertThat(sortedList.get(5).getAmount(), equalTo(2300d));
        assertThat(sortedList.get(6).getAmount(), equalTo(2000d));
        assertThat(sortedList.get(7).getAmount(), equalTo(1000d));
        assertThat(sortedList.get(8).getAmount(), equalTo(300d));
        assertThat(sortedList.get(9).getAmount(), equalTo(300d));

    }

    @Test
    public void sortByAmountAsc() {
        Comparator<Transaction> sortByAmountAscComparator = new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                return t1.getAmount().compareTo(t2.getAmount());
            }
        };

        //When : Operation to sort the transactions by Amount in Asc order is performed
        List<Transaction> sortedList = TransactionHelper.sortTransactions(transactionList, sortByAmountAscComparator);

        //Then : Transactions will be sorted by Amount in Asc order
        assertThat(sortedList.size(), equalTo(10));
        assertThat(sortedList.get(9).getAmount(), equalTo(50000d));
        assertThat(sortedList.get(8).getAmount(), equalTo(40000d));
        assertThat(sortedList.get(7).getAmount(), equalTo(30000d));
        assertThat(sortedList.get(6).getAmount(), equalTo(22000d));
        assertThat(sortedList.get(5).getAmount(), equalTo(10000d));
        assertThat(sortedList.get(4).getAmount(), equalTo(2300d));
        assertThat(sortedList.get(3).getAmount(), equalTo(2000d));
        assertThat(sortedList.get(2).getAmount(), equalTo(1000d));
        assertThat(sortedList.get(1).getAmount(), equalTo(300d));
        assertThat(sortedList.get(0).getAmount(), equalTo(300d));

    }
}
