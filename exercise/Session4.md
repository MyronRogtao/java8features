## Exercise: Method Referencing

Convert the following lambda expressions into Method references :
````
    1.  (Integer i) -> System.out.println(i);
    
    2.  (String s) -> s.length();
    
    3.  (Integer a, Integer b) -> Math.max(a, b);
    
    4.  () -> new ArrayList();
    
    5.  (s1, s2) -> { return s1.compareTo(s2); };
    
    6.  (a, b) -> { return a.concat(b); };
    
````


___
#### More Tasks
*  Given a List of transactions, write a method that takes in a transaction and prints its details. (toString())
    ````
    List<Transaction> transactions = ...
    
    //Iterate over the list and print the transaction using print() method.
    
    public void print(Transaction transaction) {
        //printing logic
    }
    ````
    
    For the same List of Transactions, explore the _forEach()_ method available on the List interface. (forEach() takes Consumer<T> as its parameter)
    
    Provide Consumer implementation as parameter of the forEach() method using a lambda expression.
    
    Next, replace the lambda with the reference of the _print()_ method.
    
    
*  Given a List of Transactions, perform sorting of transactions based on given condition.
    eg : [SortBySourceAsc.java](https://github.com/MyronRogtao/java8features/blob/master/src/main/java/my/tutorials/behaviorparameterization/stratergy/sort/transaction/SortBySourceAsc.java)
    
    Instead of defining a separate class for the comparator, lets explore the _sort()_ method on the List object.
    (sort() takes Comparator<T> as its parameter)
    
    Sort the Transactions based on Amount. Provide comparator logic with the help of lambda expression.
    
    Replace the lambda expression with method reference.
    
*  We saw an example where in we convert a two-argument Transaction constructor into a constructor reference.

    ````
    BiFunction<String, Double, Transaction> objectMapper = Transaction::new
    ````
    
    With two-Argument constructor
    ````
    class Transaction {
    
        ...
        
        public Transaction(String source, Double amount) {
            ...
        }
    
    }
    ````
   What would you need to do in order to use a constructor reference for a three-argument constructor such as Transaction(String source, String destination, Double amount)?