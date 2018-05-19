## Exercise: Functional Interfaces and Lambda Expressions

Identify valid Lambda Expressions :
````
    1.  () -> {};
    
    2.  (Integer i) -> { return i*i; };
    
    3.  Integer i -> { return i*i*i; };
    
    4.  (String a, b) -> { return a+b; };
    
    5.  (a, String b) -> { return a+b; };
    
    6.  (a, b) -> { return a+b };
    
    7.  (a, b) -> return a+b;
    
    8.  (Integer a, Integer b) -> { return a+b; };
    
    9.  (Integer a, Integer b) -> a+b;
    
    10. (a, b) -> a+b;
    
    11. () -> return "Supplier String";
    
    12. () -> "Supplier String";
    
    13. () -> { "Supplier String"; };
    
    14. a -> a*a*a;
    
````

___
#### Writing Lambdas
  For all the previous test cases written to test Behaviour Parameterization using Ad-Hoc implementations, write new test cases whereby the anonymous class will be replaced by corresponding lambdas


___
#### Finding SAM Interfaces
  Find out the Functional Interfaces available in Java 8. Figure out the input and output of each abstract method in the Functional Interfaces


___
#### Writing more Lambdas
*  Create a Thread using **Runnable Interface**. Treat the runnable interface as a Functional interface. Provide the implementation of the run method as a lambda expression that prints _'Hello Lambda'_.
*  Write a Test case wherein you create a Comparator that compares two Transactions by amount. Verify the logic
    ````
    Comparator<Transaction> compareByAmount = ...
    ````
    After the Lambda expression is written for the comparator, determine whether the same lambda can be written in the context of any other built-in Java 8 Functional Interface.