# CA#2 - Data structures and algorithms
This assignment aims to present practical knowledge of data structures and algorithms. The app has been created as a
Gradle project. The source files are located in
`/src/main/java/com/ca2` the unit tests are located in `/src/test/java/com/ca2`.

## Generics lists

The first requirement was to create its own Generics list based on the given interface
[IList](src/main/java/com/ca2/IList.java). The two lists have been
created [GenericArrayList](src/main/java/com/ca2/GenericArrayList.java) and
[GenericLinkedList](src/main/java/com/ca2/GenericLinkedList.java).

Both lists accept generic types amd implemented itteration, for example:

```java
import com.ca2.GenericArrayList;
import com.ca2.GenericLinkedList;

GenericArrayList<Integer> arrayListInt=new GenericArrayList<>();
        arrayListInt.add(1);
        GenericArrayList<String> arrayListStr=new GenericArrayList<>();
        arrayListStr.add("String");

// interate over arrayListInt
        for(item:arrayListInt){
            System.out.println(item);
        }

        GenericLinkedList<Integer> linkedListInt=new GenericLinkedList<>();
        linkedListInt.add(1);
        GenericLinkedList<String> linkedListStr=new GenericLinkedList<>();
        linkedListStr.add("String");

// interate over linkedListInt
        for(item:linkedListInt){
            System.out.println(item);
        }
```

## GenericStack and GenericQueue

The next requirement was to create its own [GenericStack](src/main/java/com/ca2/GenericStack.java)
based on given interface [IStack](src/main/java/com/ca2/IStack.java)
and [GenericQueue](src/main/java/com/ca2/GenericQueue.java)
based on given interface [IQueue](src/main/java/com/ca2/IQueue.java).

GenericStack and GenericQueue accepts GenericArrayList (default) and GenericLinkedList in constructor. Both generic
class are able to iterate by returns
[GenericIteratorStackQueue](src/main/java/com/ca2/GenericIteratorStackQueue.java)
in their iterate methods.

## Infix expression calculator

This requirement was to create the Infix calculator using an operator Stack and an operand Stack. The tester class which
reads expression from the keyboard is located in
[InfixCalculatorTester](src/main/java/com/ca2/InfixCalculatorTester.java), this class calls evaluate static method
located in [InfixCalculator](src/main/java/com/ca2/InfixCalculator.java).

Evaluate method throws the Exception if infix expression does not begin with an open bracket and not ends with a close bracket.

INVALID EXPRESSION:

~~~
(10 + 3) * 4
~~~

VALID EXPRESSION:

~~~
((10 + 3) * 4)
~~~

The app is parsing the expression and removes the white spaces and all not digit symbols.

## GenericCollections class

[GenericCollections](src/main/java/com/ca2/GenericCollections.java)
class contains static methods that operate on collections, such as GenericArrayList and GenericLinkedList.

One of the requirement was to return the maximum element of the given collection.
The [Person](src/main/java/com/ca2/Person.java) class have been used to test this functionality. The tester app is
available in [GenericCollectionsTester](src/main/java/com/ca2/GenericCollectionsTester.java). The next requirement was
to implement rotate method in GenericCollections class.

## Analysis of rotate methods

This requirement was to add rotate method to the IList interface and implement those methods to GenericArrayList and
GenericLinkedList. Then the next requirement was to provide a performance analysis of the differences in the rotate
methods applied to GenericArrayList and GenericLinkedList.

### Method

To measure the execution times the classes below have been used:
1. [AnalysisListMethods](src/main/java/com/ca2/rotateAnalysis/AnalysisListMethods.java) - the app generates the MD file
   contains a table with execution times for add, remove, set and get methods performed on IList
2. [RotateAnalysis](src/main/java/com/ca2/rotateAnalysis/RotateAnalysis.java) - the app generates the MD file
   contains a table with execution times for rotate, GenericCollection.rotate and GenericCollection.rotate2 methods performed on IList
3. [Analysis](src/main/java/com/ca2/rotateAnalysis/Analysis.java) - it returns the execution times for the methods
4. [AnalysisTable](src/main/java/com/ca2/rotateAnalysis/AnalysisTable.java) - generates the table in md format
5. [FileManagement](src/main/java/com/ca2/rotateAnalysis/FileManagement.java) - generates the file
6. [Timer](src/main/java/com/ca2/rotateAnalysis/Timer.java) - measures the time

The generated MD files are located in [Methods execution times analysis](analysis-methods.md) and
[Rotate execution times analysis](analysis-rotate.md)

### Conclusions

The rotate method in both IList classed execute two operations remove and add at position 0. In GenericArrayList, remove
operation takes O(n) time. The list must be iterated to find the element for removal and update the position of the rest
items. Add method in GenericArrayList takes O(n) time to add an element on the first position the iteration must be
performed to update the position of the rest items.

In GenericLinkedList, remove operation takes O(n) time. The list must be iterated to update the nodes' positions. Add
method in GenericLinkedList takes O(1) time to add an element at the first position. Which makes the GenericLinkedList
faster than GenericArrayList by calling the rotate method directly from the list.

GenericCollection.rotate calls twice, get and set methods. In GenericArrayList get takes O(1) time, and set method takes
O(n) time. In GenericLinkedList, get and set methods takes O(1) time. GenericArrayList is usually faster than
GenericLinkedList when called in the GenericCollection rotate method. The table below shows the operation time for the
methods.

|  | add(0) | remove(index) | get(index) | set(index) |
|--- | --- | --- | --- | --- |
| GenericArrayList | O(n) | O(n) | O(1) | O(n) |
| GenericLinkedList | O(1) | O(n) | O(n) | O(n) |

### Author: Mariusz Januszkiewicz L00162996@student.lyit.ie
