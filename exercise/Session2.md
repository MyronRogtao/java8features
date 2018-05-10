## Exercise : Behavior Parameterization extended

  
#### Requirement :  Display Transaction details.

```
Client 1 : Given a transaction, display the transaction details as a plain string. (toSting())
                       (Transaction -> String)
```
```
Client 2 : Given a transaction, display the transaction details as per TransactionDetails model.
                            type            : will hold transaction type
                            formattedAmount : will hold formatted transaction amount. eg: ($ amount)
                            partiesInvolved : will hold colon separated transaction source and destination info. eg:  source:destination
                       (Transaction -> TransactionDetails)
```

##### Your Tasks:
___
1. Define the mapping function as a strategy. 
      
    Create an Interface **TransactionMapper.java** that will have an abstract function that takes in Transaction object and returns any type of object.
    _(Do not use Object as the return type. Use Generics)_
2. With this contract defined, write test cases in **TransactionMapperTest.java** to test each clients requirement. Provide ad-hoc implementation of **TransactionMapper.java** based on the requirements.
3. Test the output.
4. Lets go a step further and define a Generic mapper **Mapper.java**.

   **Mapper.java** will be a generic interface that will expose a contract accepting one type of object and returning another type of object.
   _Stick to the concept of using Generics ;)_ 
   
5. Add test cases in **TransactionMapperTest.java** that will verifying the use of **Mapper.java** in fulfilling the clients requirement.
___


#### Requirement : Sort Transactions
___
 1. Given a list of Transactions, we cab provide different sort strategies using the Comparator interface.
    
 2. Refer **TransactionSortTest.java**. Provide ad-hoc implementation to the comparator based on the test method requirement.
    
 3. Verify the sorted output.
___