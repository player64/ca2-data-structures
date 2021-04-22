# CA#2 - Data structures and algorithms
Aim of this assignment is to present practical knowledge of data structures and algorithms. 
The app has been created as Gradle project. The source files are located in
`/src/main/java/com/ca2` the unit test are located in `/src/test/java/com/ca2`.

## Generics lists
The first requirement was to create its own Generics list based on the given interface
[IList](src/main/java/com/ca2/IList.java).
The two lists have been created [GenericArrayList](src/main/java/com/ca2/GenericArrayList.java) and 
[GenericLinkedList](src/main/java/com/ca2/GenericLinkedList.java).

Both lists accept generic types amd implemented itteration, for example:
```java
import com.ca2.GenericArrayList;
import com.ca2.GenericLinkedList;

GenericArrayList<Integer> arrayListInt = new GenericArrayList<>();
arrayListInt.add(1);
GenericArrayList<String> arrayListStr = new GenericArrayList<>();
arrayListStr.add("String");

// interate over arrayListInt
for(item : arrayListInt) {
    System.out.println(item);
}

GenericLinkedList<Integer> linkedListInt = new GenericLinkedList<>();
linkedListInt.add(1);
GenericLinkedList<String> linkedListStr = new GenericLinkedList<>();
linkedListStr.add("String");

// interate over linkedListInt
for(item : linkedListInt) {
    System.out.println(item);
}
```

## GenericStack and GenericQueue
The next requirement was to create its own [GenericStack](src/main/java/com/ca2/GenericStack.java) 
based on given interface [IStack](src/main/java/com/ca2/IStack.java)
and [GenericQueue](src/main/java/com/ca2/GenericQueue.java)
based on given interface [IQueue](src/main/java/com/ca2/IQueue.java).

GenericStack and GenericQueue accepts GenericArrayList (default) and GenericLinkedList in constructor.
Both generic class are able to iterate by returns 
[GenericIteratorStackQueue](src/main/java/com/ca2/GenericIteratorStackQueue.java)
in their iterate methods.

## Infix expression calculator
This requirement was to create the Infix calculator using an operator Stack and an operand Stack.
The tester class which reads expression from the keyboard is located in
[InfixCalculatorTester](src/main/java/com/ca2/InfixCalculatorTester.java), this class calls evaluate static method
located [InfixCalculator](src/main/java/com/ca2/InfixCalculator.java). 

Evaluate method throws the Exception if infix expression is not beginning of open bracket and not ends with close bracket. 

INVALID EXPRESSION:
~~~
(10 + 3) * 4
~~~

VALID EXPRESSION:
~~~
((10 + 3) * 4)
~~~

High Performance Programming 
The app is parsing the expression and removes the white spaces and all not digit symbols.

## GenericCollections class
[GenericCollections](src/main/java/com/ca2/GenericCollections.java)
class contains static methods that operate on collections, such as GenericArrayList 
and GenericLinkedList. 

One of the requirement was to return the maximum element of the given collection. 
The [Person](src/main/java/com/ca2/Person.java) class have been used to test this functionality. 
The tests are available in [GenericCollectionsTest](src/test/java/com/ca2/GenericCollectionsTest.java).
The next requirement was to implement rotate method in GenericCollections class.

## Analysis of rotate methods
This requirement was to add rotate method to IList interface and implement this method to GenericArrayList 
and GenericLinkedList. 
Then the next requirement was to provide a performance analysis of the differences in the rotate methods
applied to GenericArrayList and GenericLinkedList.

### Method

### Conclusions
The rotate method in both IList classed execute two operations remove and add at position 0.
In GenericArrayList, remove operation takes O(n) time. The list must be iterated to find the element for removal and 
update the position of the rest items.
Add method in GenericArrayList takes O(n) time to add an element on the first position the iteration must be performed
to update the position of the rest items.

In GenericLinkedList, remove operation takes O(n) time. The list must be iterated to update the nodes' positions.
Add method in GenericLinkedList takes O(1) time to add an element at the first position. 
Which makes the GenericLinkedList faster than GenericArrayList by calling rotate method directly in the list.


GenericCollection.rotate calls twice get and set methods. In GenericArrayList get and set method takes O(1) time. 
In GenericLinkedList and set method takes O(1) time. GenericArrayList is usually faster than GenericLinkedList when called 
in the GenericCollection rotate method.
The table below show the operation time for the methods. 

|  | add(0) | remove(index) | get(index) | set(index) |
|--- | --- | --- | --- | --- |
| GenericArrayList | O(n) | O(n) | O(1) | O(n) |
| GenericLinkedList | O(1) | O(n) | O(n) | O(n) |
[Method calculations](analysis-methods.md)

[Rotate analysis](analysis-rotate.md)

