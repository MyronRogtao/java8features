package my.tutorials.behaviorparameterization;

import my.tutorials.behaviorparameterization.helper.GenericHelper;
import my.tutorials.behaviorparameterization.stratergy.generic.Predicate;
import my.tutorials.model.Person;
import my.tutorials.helper.DataHelper;
import my.tutorials.model.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericFilterPredicateTest {

    private List<Transaction> transactionList = new ArrayList<>();
    private List<Person> peopleList = new ArrayList<>();

    @Before
    public void init() {
        //Given : List of Transactions
        transactionList = DataHelper.initTransactions();
        peopleList = DataHelper.initPeople();

    }

    @Test
    public void filterTransactionByGenericFilter() {
        Predicate<Transaction> predicate = new Predicate<Transaction>() {
            @Override
            public boolean filter(Transaction entity) {
                return entity.getAmount() > 2000d;
            }
        };

        List<Transaction> filteredTransactions = GenericHelper.filterData(transactionList, predicate);

        for(Transaction transaction : filteredTransactions) {
            assertThat(transaction.getAmount()).isGreaterThan(2000d);
        }
    }

    @Test
    public void filterPeopleByGenericFilter() {
        Predicate<Person> predicate = new Predicate<Person>() {
            @Override
            public boolean filter(Person entity) {
                return entity.getName().startsWith("Mar");
            }
        };

        List<Person> filteredPeople = GenericHelper.filterData(peopleList, predicate);

        for(Person person : filteredPeople) {
            assertThat(person.getName()).startsWith("Mar");
        }
    }
}
