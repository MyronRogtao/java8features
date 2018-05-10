package my.tutorials.helper;

import my.tutorials.model.Person;
import my.tutorials.model.Transaction;

import java.util.ArrayList;
import java.util.List;

import static my.tutorials.model.TxnType.CREDIT;
import static my.tutorials.model.TxnType.DEBIT;

public class DataHelper {

    public static List<Transaction> initTransactions() {
        List<Transaction> transactionList = new ArrayList<>();

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

        return transactionList;
    }

    public static List<Person> initPeople() {
        return io.vavr.collection.List.of(
                new Person("Zayne", 12),
                new Person("Marsh", 27),
                new Person("Elroy", 21),
                new Person("Darius", 20),
                new Person("Adrian", 43),
                new Person("Keziah", 22)
        ).toJavaList();
    }
}
