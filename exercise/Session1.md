## Exercise: Behavior Parameterization

Consider a Person entity :
````
    public class Person {
      private String name;
      private int age;
    }
````
Refer : [Person.java](https://github.com/MyronRogtao/java8features/blob/master/src/main/java/my/tutorials/behaviorparameterization/model/Person.java)

___
#### Requirement 1: (Write a standalone function)
  Given a list of People, filter all people with names starting with 'a' or 'm'

___
#### Requirement 2: (Write a standalone function)
  Given a list of People, filter all people with names greater than 5 characters and age greater than 20.

___
#### Code Reuse : (Use of Polymorphism)
  Given the 2 functions, written to satisfy Requirement 1 and 2, write a common function that will accept the filtering behaviour as a parameter.

  Use PersonPredicate as the interface with the filter method, accepting Person entity and returning a boolean value.
  Define 2 implementations of the PersonPredicate that will satisfy Requirement 1 and 2.

___
#### Reduce Verbosity: (Use anonymous classes)
  Let us now provide ad-hoc implementations of PersonPredicate to satisfy Requirement 1 and 2.

___
#### Generalizing Filter:
The **TransactionPredicate** and **PersonPredicate** provide a contract that has the same meaning.

 > **_Take an entity, and return a boolean value._**

Write a common Predicate that can be used to for both Person as well as Transaction Predicates.
_(Hint : Use Generic Type to represent the accepted entity in the filter method)_

___
#### Additional Tasks :
* Figure out the drawbacks of using Anonymous classes