package my.tutorials.behaviorparameterization;

import my.tutorials.behaviorparameterization.model.Transaction;
import my.tutorials.behaviorparameterization.stratergy.filter.transaction.FilterByAmountCreditAndSource;
import my.tutorials.behaviorparameterization.stratergy.filter.transaction.TransactionPredicate;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static my.tutorials.behaviorparameterization.helper.TransactionHelper.*;
import static my.tutorials.behaviorparameterization.model.TxnType.CREDIT;
import static my.tutorials.behaviorparameterization.model.TxnType.DEBIT;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionFilterTestCases {

    private List<Transaction> transactionList = new ArrayList<>();

    @Before
    public void init() {
        //Given : List of Transactions
        initTransactions();
    }

    @Test
    public void filterTransactionsGreaterThan2000() {
        //When : Filter Transactions whose amount is greater than 2000 units
        List<Transaction> filteredTransactions = findTransactionsGreaterThan2000(transactionList);

        //Then : Transactions greater than 2000 are made available
        for (Transaction filteredTransaction : filteredTransactions) {
            assertThat(filteredTransaction.getAmount()).isGreaterThan(2000d);
        }
    }

    @Test
    public void filterTransactionsGreaterThan3000() {
        //When : Filter Transactions whose amount is greater than 3000 units
        List<Transaction> filteredTransactions = findTransactionsGreaterThan3000(transactionList);

        //Then : Transactions greater than 3000 are made available
        for (Transaction filteredTransaction : filteredTransactions) {
            assertThat(filteredTransaction.getAmount()).isGreaterThan(3000d);
        }
    }

    @Test
    public void filterTransactionsGreaterThanGivenAmount() {
        //When : Filter Transactions whose amount is greater than 5000 units
        List<Transaction> filteredTransactions = findTransactionsGreaterThanGivenAmount(transactionList, 5000d);

        //Then : Transactions greater than 5000 are made available
        for (Transaction filteredTransaction : filteredTransactions) {
            assertThat(filteredTransaction.getAmount()).isGreaterThan(5000d);
        }
    }

    @Test
    public void filterTransactionsGreaterThanGivenAmountOfTypeCreditAndCarriedOutByX() {
        //When : Filter Transactions whose amount is greater than 5000 units
        List<Transaction> filteredTransactions = findTransactionsGreaterThanGivenAmountOfTypeCreditCarriedOutByX(transactionList, 5000d);

        //Then : Transactions greater than 5000, of type CREDIT, carried out by X are made available
        for (Transaction filteredTransaction : filteredTransactions) {
            assertThat(filteredTransaction.getAmount()).isGreaterThan(5000d);
            assertThat(filteredTransaction.getType()).isEqualTo(CREDIT);
            assertThat(filteredTransaction.getSource()).isEqualToIgnoringCase("X");
        }
    }

    @Test
    public void filterByPredicate() {
        List<Transaction> filteredTransactions = filterTransactionByPredicate(transactionList, new FilterByAmountCreditAndSource());

        for (Transaction filteredTransaction : filteredTransactions) {
            assertThat(filteredTransaction.getAmount()).isGreaterThan(2000d);
            assertThat(filteredTransaction.getType()).isEqualTo(CREDIT);
            assertThat(filteredTransaction.getSource()).isEqualToIgnoringCase("X");
        }
    }

    @Test
    public void filterByPredicateUsingAnonymousPredicate() {
        //Use of Anonymous Classes eliminates the need to write the code to specify the behaviour in each filter class.
        List<Transaction> filteredTransactions = filterTransactionByPredicate(transactionList, new TransactionPredicate() {
            @Override
            public boolean filter(Transaction transaction) {
                return transaction.getAmount() > 3000d && transaction.getDestination().equalsIgnoreCase("Y");
            }
        });

        for (Transaction filteredTransaction : filteredTransactions) {
            assertThat(filteredTransaction.getAmount()).isGreaterThan(3000d);
            assertThat(filteredTransaction.getDestination()).isEqualToIgnoringCase("Y");
        }
    }

    private void initTransactions() {
        transactionList.add(new Transaction(CREDIT, "X", "Y", 30000d));
        transactionList.add(new Transaction(DEBIT, "X", "Y", 1000d));
        transactionList.add(new Transaction(DEBIT, "Z", "A", 2000d));
        transactionList.add(new Transaction(CREDIT, "A", "B", 40000d));
        transactionList.add(new Transaction(CREDIT, "X", "Z", 10000d));
        transactionList.add(new Transaction(CREDIT, "X", "A", 300d));
        transactionList.add(new Transaction(CREDIT, "X", "Y", 50000d));
        transactionList.add(new Transaction(DEBIT, "B", "C", 2300d));
        transactionList.add(new Transaction(CREDIT, "C", "B", 22000d));
        transactionList.add(new Transaction(DEBIT, "A", "Z", 300d));
    }
}
