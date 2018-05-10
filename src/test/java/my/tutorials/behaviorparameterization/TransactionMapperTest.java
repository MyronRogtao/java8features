package my.tutorials.behaviorparameterization;

import my.tutorials.model.Transaction;
import my.tutorials.model.TxnType;
import org.junit.Before;
import org.junit.Test;

public class TransactionMapperTest {

    private Transaction transaction;

    @Before
    public void init() {
        transaction = new Transaction(TxnType.CREDIT, "Mark", "Spencer", 20000d);
    }

    @Test
    public void mapTransactionBasedOnClient1Requirement() {

    }

    @Test
    public void mapTransactionBasedOnClient2Requirement() {

    }

}
