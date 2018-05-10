package my.tutorials.behaviorparameterization;

import my.tutorials.behaviorparameterization.stratergy.filter.transaction.FilterByAmount;
import my.tutorials.model.Transaction;
import my.tutorials.behaviorparameterization.stratergy.filter.transaction.FilterByAmountCreditAndSource;
import my.tutorials.behaviorparameterization.stratergy.filter.transaction.TransactionPredicate;
import my.tutorials.helper.DataHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static my.tutorials.behaviorparameterization.helper.TransactionHelper.*;
import static my.tutorials.model.TxnType.CREDIT;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionFilterTestCases {

    private List<Transaction> transactionList = new ArrayList<>();

    @Before
    public void init() {
        //Given : List of Transactions
        transactionList = DataHelper.initTransactions();
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
    public void filterByAmountPredicate() {
        //When : Filter Transactions whose amount is greater than 2000 units
        List<Transaction> filteredTransactions = filterTransactionByPredicate(transactionList, new FilterByAmount());

        //Then : Transactions greater than 2000 units are made available
        for (Transaction filteredTransaction : filteredTransactions) {
            assertThat(filteredTransaction.getAmount()).isGreaterThan(2000d);
        }
    }

    @Test
    public void filterByPredicate() {
        //When : Filter Credit type Transactions whose amount is greater than 2000 units and carried out by X
        List<Transaction> filteredTransactions = filterTransactionByPredicate(transactionList, new FilterByAmountCreditAndSource());

        //Then : Transactions greater than 2000, of type CREDIT, carried out by X are made available
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
}
