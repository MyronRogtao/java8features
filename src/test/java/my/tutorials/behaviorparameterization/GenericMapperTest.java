package my.tutorials.behaviorparameterization;

import my.tutorials.behaviorparameterization.stratergy.generic.Mapper;
import my.tutorials.model.Person;
import my.tutorials.model.Transaction;
import my.tutorials.model.TxnType;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GenericMapperTest {

    private Transaction transaction;

    @Before
    public void init() {
        transaction = new Transaction(TxnType.CREDIT, "Mark", "Spencer", 20000d);
    }

    @Test
    public void mapTransactionToString() {
        //Given : Transaction to String Mapper
        Mapper<Transaction, String> txnToString = new Mapper<Transaction, String>() {
            @Override
            public String map(Transaction data) {
                return data.toString();
            }
        };

        //When : Transaction is mapped
        String mappedTransaction = txnToString.map(transaction);

        //Then : The returned string must be valid
        assertThat(mappedTransaction, equalTo("Transaction(type = CREDIT, source = Mark, destination = Spencer, amount = 20000.0)"));
    }

    @Test
    public void mapIntegerToString() {
        //Given : Integer to String Mapper
        Mapper<Integer, String> intToString = new Mapper<Integer, String>() {
            @Override
            public String map(Integer data) {
                return "MappedIntToString : "+data;
            }
        };

        //When : Integer is mapped
        String mappedTransaction = intToString.map(100);

        //Then : The returned string must be valid
        assertThat(mappedTransaction, equalTo("MappedIntToString : 100"));
    }

    @Test
    public void mapPersonToString() {
        //Given a Person to person name mapper
        Mapper<Person, String> personToString = new Mapper<Person, String>() {
            @Override
            public String map(Person person) {
                return person.getName() + "("+ person.getAge() +")";
            }
        };

        //When : Person object is mapped
        String mappedOutput = personToString.map(new Person("John Doe", 33));

        //Then : Mapped output must be valid
        assertThat(mappedOutput, equalTo("John Doe(33)"));

    }

}
