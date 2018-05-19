package my.tutorials.functionalinterface;

import my.tutorials.functionalInterface.Consumer;
import my.tutorials.functionalInterface.Function;
import my.tutorials.functionalInterface.Predicate;
import my.tutorials.functionalInterface.Supplier;
import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;
import my.tutorials.model.TxnType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class ContractTest {

    private Transaction transaction;

    @Before
    public void init() {
        transaction = new Transaction(TxnType.CREDIT, "Mark", "Spencer", 20000d);
    }

    @Test
    public void consumerAdHodImplementation() {
        Consumer<Transaction> txnConsumer = new Consumer<Transaction>() {
            @Override
            public void consume(Transaction transaction) {
                System.out.println(transaction.toString());
            }
        };

        txnConsumer.consume(transaction);

    }

    @Test
    public void consumerLambdaImplementation() {
        Consumer<Transaction> txnConsumer = (Transaction txn) -> {
            System.out.println(txn.toString());
        };

        txnConsumer.consume(transaction);
    }

    @Test
    public void consumerLambdaImplementationMoreConcise() {
        Consumer<Transaction> txnConsumer = txn -> System.out.println(txn.toString());

        txnConsumer.consume(transaction);
    }

    @Test
    public void consumerLambdaImplementationEvenMoreConcise() {
        Consumer<Transaction> txnConsumer = System.out::println;

        txnConsumer.consume(transaction);
    }

    @Test
    public void functionAdHocImplementation() {
        Function<Transaction, TransactionDetails> txnMapper = new Function<Transaction, TransactionDetails>() {
            @Override
            public TransactionDetails map(Transaction txn) {
                return new TransactionDetails(txn.getType().name(),
                        txn.getAmount().toString(),
                        txn.getSource().concat(":".concat(txn.getDestination())));
            }
        };

        TransactionDetails details = txnMapper.map(transaction);

        assertNotNull(details);
        assertThat(details.getType(), equalTo("CREDIT"));
        assertThat(details.getFormattedAmount(), equalTo("20000.0"));
        assertThat(details.getPartiesInvolved(), equalTo("Mark:Spencer"));
    }

    @Test
    public void functionLambdaImplementation() {
        Function<Transaction, TransactionDetails> txnMapper = (Transaction txn) -> {
            return new TransactionDetails(txn.getType().name(),
                    txn.getAmount().toString(),
                    txn.getSource().concat(":".concat(txn.getDestination())));
        };

        TransactionDetails details = txnMapper.map(transaction);

        assertNotNull(details);
        assertThat(details.getType(), equalTo("CREDIT"));
        assertThat(details.getFormattedAmount(), equalTo("20000.0"));
        assertThat(details.getPartiesInvolved(), equalTo("Mark:Spencer"));
    }

    @Test
    public void functionLambdaImplementationMoreConcise() {
        Function<Transaction, TransactionDetails> txnMapper = txn -> {
            return new TransactionDetails(txn.getType().name(),
                    txn.getAmount().toString(),
                    txn.getSource().concat(":".concat(txn.getDestination())));
        };

        TransactionDetails details = txnMapper.map(transaction);

        assertNotNull(details);
        assertThat(details.getType(), equalTo("CREDIT"));
        assertThat(details.getFormattedAmount(), equalTo("20000.0"));
        assertThat(details.getPartiesInvolved(), equalTo("Mark:Spencer"));
    }

    @Test
    public void functionLambdaImplementationEvenMoreConcise() {
        Function<Transaction, TransactionDetails> txnMapper = txn -> new TransactionDetails(txn.getType().name(),
                txn.getAmount().toString(),
                txn.getSource().concat(":".concat(txn.getDestination())));

        TransactionDetails details = txnMapper.map(transaction);

        assertNotNull(details);
        assertThat(details.getType(), equalTo("CREDIT"));
        assertThat(details.getFormattedAmount(), equalTo("20000.0"));
        assertThat(details.getPartiesInvolved(), equalTo("Mark:Spencer"));
    }

    @Test
    public void predicateAdHocImplementation() {
        Predicate<Transaction> txnPredicate = new Predicate<Transaction>() {
            @Override
            public boolean test(Transaction txn) {
                return txn.getAmount()>2000d;
            }
        };

        boolean result = txnPredicate.test(transaction);

        assertTrue(result);
    }

    @Test
    public void predicateLambdaImplementation() {
        Predicate<Transaction> txnPredicate = (Transaction txn) -> {
                return txn.getAmount()>2000d;
            };

        boolean result = txnPredicate.test(transaction);

        assertTrue(result);
    }

    @Test
    public void predicateLambdaImplementationMoreConcise() {
        Predicate<Transaction> txnPredicate = txn -> txn.getAmount()>2000d;

        boolean result = txnPredicate.test(transaction);

        assertTrue(result);
    }

    @Test
    public void supplierAdHocImplementation() {
        Supplier<Transaction> txnSupplier = new Supplier<Transaction>() {
            @Override
            public Transaction get() {
                return new Transaction();
            }
        };

        Transaction txn = txnSupplier.get();

        assertNotNull(txn);
        assertNull(txn.getAmount());
        assertNull(txn.getType());
        assertNull(txn.getSource());
        assertNull(txn.getDestination());
    }

    @Test
    public void supplierLambdaImplementation() {
        Supplier<Transaction> txnSupplier = () -> { return new Transaction(); };

        Transaction txn = txnSupplier.get();

        assertNotNull(txn);
        assertNull(txn.getAmount());
        assertNull(txn.getType());
        assertNull(txn.getSource());
        assertNull(txn.getDestination());
    }

    @Test
    public void supplierLambdaImplementationMoreConcise() {
        Supplier<Transaction> txnSupplier = () -> new Transaction();

        Transaction txn = txnSupplier.get();

        assertNotNull(txn);
        assertNull(txn.getAmount());
        assertNull(txn.getType());
        assertNull(txn.getSource());
        assertNull(txn.getDestination());
    }

    @Test
    public void supplierLambdaImplementationEvenMoreConcise() {
        Supplier<Transaction> txnSupplier = Transaction::new;

        Transaction txn = txnSupplier.get();

        assertNotNull(txn);
        assertNull(txn.getAmount());
        assertNull(txn.getType());
        assertNull(txn.getSource());
        assertNull(txn.getDestination());
    }
}
