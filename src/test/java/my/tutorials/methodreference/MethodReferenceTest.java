package my.tutorials.methodreference;

import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;
import my.tutorials.model.TxnType;
import org.junit.Before;
import org.junit.Test;

import java.util.function.*;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

public class MethodReferenceTest {

    private Transaction transaction;

    @Before
    public void init() {
        transaction = new Transaction(TxnType.CREDIT, "Mark", "Spencer", 20000d);
    }

    @Test
    public void consumerLambdaImplementation() {
        Consumer<Transaction> txnConsumer = txn -> System.out.println(txn.toString());

        txnConsumer.accept(transaction);
    }

    @Test
    public void consumerLambdaWithInstanceMethodReference() {
        //We can replace the lambda by providing the reference of any instance method that has the same signature
        MethodReferenceHelper helperObject = new MethodReferenceHelper();
        Consumer<Transaction> txnConsumer = helperObject::print;

        txnConsumer.accept(transaction);
    }

    @Test
    public void consumerLambdaWithStaticMethodReference() {
        //We can replace the lambda by providing the reference of any static method that has the same signature
        Consumer<Transaction> txnConsumer = MethodReferenceHelper::printData;

        txnConsumer.accept(transaction);
    }

    @Test
    public void predicateLambdaWithInstanceMethodReference() {
        //We can replace the lambda by providing the reference of any instance method that has the same signature
        MethodReferenceHelper helperObject = new MethodReferenceHelper();
        Predicate<Transaction> txnPredicate = helperObject::validateTransaction;

        boolean isValidTxn = txnPredicate.test(transaction);

        assertTrue(isValidTxn);
    }

    @Test
    public void predicateLambdaWithStaticMethodReference() {
        //We can replace the lambda by providing the reference of any static method that has the same signature
        Predicate<Transaction> txnPredicate = MethodReferenceHelper::validateTxn;

        boolean isValidTxn = txnPredicate.test(transaction);

        assertTrue(isValidTxn);
    }

    @Test
    public void functionLambdaImplementationMoreConcise() {
        Function<Transaction, TransactionDetails> txnMapper = txn -> {
            return new TransactionDetails(txn.getType().name(),
                    txn.getAmount().toString(),
                    txn.getSource().concat(":".concat(txn.getDestination())));
        };

        TransactionDetails details = txnMapper.apply(transaction);

        assertNotNull(details);
        assertThat(details.getType(), equalTo("CREDIT"));
        assertThat(details.getFormattedAmount(), equalTo("20000.0"));
        assertThat(details.getPartiesInvolved(), equalTo("Mark:Spencer"));
    }

    @Test
    public void functionLambdaWithInstanceMethodReference() {
        //We can replace the lambda by providing the reference of any instance method that has the same signature
        MethodReferenceHelper helperObject = new MethodReferenceHelper();
        Function<Transaction, TransactionDetails> txnMapper = helperObject::mapTransaction;

        TransactionDetails txnDetails = txnMapper.apply(transaction);

        assertNotNull(txnDetails);
        assertThat(txnDetails.getType(), equalTo("CREDIT"));
        assertThat(txnDetails.getFormattedAmount(), equalTo("$20000.0"));
        assertThat(txnDetails.getPartiesInvolved(), equalTo("Mark:Spencer"));
    }

    @Test
    public void functionLambdaWithStaticeMethodReference() {
        //We can replace the lambda by providing the reference of any static method that has the same signature
        Function<Transaction, TransactionDetails> txnMapper = MethodReferenceHelper::mapTransactionDetails;

        TransactionDetails txnDetails = txnMapper.apply(transaction);

        assertNotNull(txnDetails);
        assertThat(txnDetails.getType(), equalTo("CREDIT"));
        assertThat(txnDetails.getFormattedAmount(), equalTo("$20000.0"));
        assertThat(txnDetails.getPartiesInvolved(), equalTo("Mark:Spencer"));
    }

    @Test
    public void predicateLambdaImplementation() {
        my.tutorials.functionalInterface.Predicate<Transaction> txnPredicate = (Transaction txn) -> {
            return txn.getAmount() > 2000d;
        };

        boolean result = txnPredicate.test(transaction);

        assertTrue(result);
    }

    @Test
    public void biFunctionLambda() {
        BiFunction<Transaction, String, TransactionDetails> txnMapper = (txn, currency) -> {
            TransactionDetails details = new TransactionDetails();
            details.setFormattedAmount(currency + txn.getAmount());
            details.setPartiesInvolved(txn.getSource()+":"+txn.getDestination());
            details.setType(txn.getType().name());
            return details;
        };

        TransactionDetails txnDetails = txnMapper.apply(transaction, "@");

        assertNotNull(txnDetails);
        assertThat(txnDetails.getType(), equalTo("CREDIT"));
        assertThat(txnDetails.getFormattedAmount(), equalTo("@20000.0"));
        assertThat(txnDetails.getPartiesInvolved(), equalTo("Mark:Spencer"));
    }

    @Test
    public void biFunctionLambdaWithInstanceMethodReference() {
        //We can replace the lambda by providing the reference of any instance method that has the same signature
        MethodReferenceHelper helperObject = new MethodReferenceHelper();
        BiFunction<Transaction, String, TransactionDetails> txnMapper = helperObject::mapTransaction;

        TransactionDetails txnDetails = txnMapper.apply(transaction, "@");

        assertNotNull(txnDetails);
        assertThat(txnDetails.getType(), equalTo("CREDIT"));
        assertThat(txnDetails.getFormattedAmount(), equalTo("@20000.0"));
        assertThat(txnDetails.getPartiesInvolved(), equalTo("Mark:Spencer"));
    }

    @Test
    public void biFunctionLambdaWithStaticMethodReference() {
        //We can replace the lambda by providing the reference of any static method that has the same signature
        BiFunction<Transaction, String, TransactionDetails> txnMapper = MethodReferenceHelper::mapTransactionDetails;

        TransactionDetails txnDetails = txnMapper.apply(transaction, "%");

        assertNotNull(txnDetails);
        assertThat(txnDetails.getType(), equalTo("CREDIT"));
        assertThat(txnDetails.getFormattedAmount(), equalTo("%20000.0"));
        assertThat(txnDetails.getPartiesInvolved(), equalTo("Mark:Spencer"));
    }

    @Test
    public void supplierTransaction() {
        Supplier<Transaction> txnSupplier = () -> new Transaction();

        Transaction transaction = txnSupplier.get();

        assertNotNull(transaction);
        assertNull(transaction.getAmount());
        assertNull(transaction.getType());
        assertNull(transaction.getSource());
        assertNull(transaction.getDestination());
    }

    @Test
    public void supplierConstructorMethodReference() {
        Supplier<Transaction> txnSupplier = Transaction::new;

        Transaction transaction = txnSupplier.get();

        assertNotNull(transaction);
        assertNull(transaction.getAmount());
        assertNull(transaction.getType());
        assertNull(transaction.getSource());
        assertNull(transaction.getDestination());
    }
}
