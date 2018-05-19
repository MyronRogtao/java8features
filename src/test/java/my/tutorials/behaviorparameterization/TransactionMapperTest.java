package my.tutorials.behaviorparameterization;

import my.tutorials.behaviorparameterization.stratergy.mapper.transaction.TransactionDetailsMapper;
import my.tutorials.behaviorparameterization.stratergy.mapper.transaction.TransactionMapper;
import my.tutorials.behaviorparameterization.stratergy.mapper.transaction.TransactionStringMapper;
import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;
import my.tutorials.model.TxnType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class TransactionMapperTest {

    private Transaction transaction;

    @Before
    public void init() {
        transaction = new Transaction(TxnType.CREDIT, "Mark", "Spencer", 20000d);
    }

    @Test
    public void mapTransactionBasedOnClient1RequirementUsingConcreteImpl() {
        //Given : Transaction to String mapping strategy
        TransactionStringMapper txnToString = new TransactionStringMapper();

        //When : Transaction is mapped
        String mappedOutput = txnToString.map(transaction);

        //Then : The returned string must be valid
        assertThat(mappedOutput, equalTo("Transaction(type = CREDIT, source = Mark, destination = Spencer, amount = 20000.0)"));
    }

    @Test
    public void mapTransactionBasedOnClient2RequirementUsingConcreteImpl() {
        //Given : Transaction to TransactionDetails mapping strategy
        TransactionDetailsMapper txnDetailsMapper = new TransactionDetailsMapper();

        //When : Transaction is mapped
        TransactionDetails txnDetails = txnDetailsMapper.map(transaction);

        //Then : Valid Transaction Details must be provided
        assertNotNull(txnDetails);
        assertThat(txnDetails.getType(), equalTo("CREDIT"));
        assertThat(txnDetails.getFormattedAmount(), equalTo("$20000.0"));
        assertThat(txnDetails.getPartiesInvolved(), equalTo("Mark:Spencer"));

    }

    @Test
    public void mapTransactionToStringUsingAdHocImpl() {

        //Given : Transaction to String mapping strategy defined by adHoc class
        TransactionMapper<String> txnToString = new TransactionMapper<String>() {
            @Override
            public String map(Transaction transaction) {
                return transaction.getSource() + "->" + transaction.getDestination() + " ("+ transaction.getAmount() +")";
            }
        };

        //When : Transaction is mapped
        String mappedOutput = txnToString.map(transaction);

        //Then : The returned string must be valid
        assertThat(mappedOutput, equalTo("Mark->Spencer (20000.0)"));
    }

    @Test
    public void mapTransactionDetailsUsingAdHocImpl() {
        //Given : Transaction to TransactionDetails mapping strategy
        TransactionMapper<TransactionDetails> txnDetailsMapper = new TransactionMapper<TransactionDetails>() {
            @Override
            public TransactionDetails map(Transaction transaction) {
                return new TransactionDetails(transaction.getType().name(), transaction.getAmount().toString(),
                        transaction.getSource() + "->" + transaction.getDestination());
            }
        };

        //When : Transaction is mapped
        TransactionDetails txnDetails = txnDetailsMapper.map(transaction);

        //Then : Valid Transaction Details must be provided
        assertNotNull(txnDetails);
        assertThat(txnDetails.getType(), equalTo("CREDIT"));
        assertThat(txnDetails.getFormattedAmount(), equalTo("20000.0"));
        assertThat(txnDetails.getPartiesInvolved(), equalTo("Mark->Spencer"));

    }

}
