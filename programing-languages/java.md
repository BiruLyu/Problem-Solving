
🔰[Top 10 Java Interview Questions Answers – Must Read Before Appearing for any Java Interview](http://crunchify.com/top-10-java-interview-questions-answers-must-read-before-appearing-for-any-java-interview/)


# Java Questions

Contents:

- [Keywords](#Keywords)
- [Concepts](#Concepts)
- [OOP](#OOP)
- [Collections](#Collections)
- [Threading](#Thread)


## Object Oriented

+ model organized around objects rather than actions and data rather than logic
+ based on the concept of "objects"
+ contain data in the form of fields(attributes)
+ code in the form of procedures(methods)
+ object's procedures can access and modify the data fields of the associated object

<a name="Keywords"/>

## Java Keywords
+ Access modifiers

  | modifier | access in same package | access in different package |
  | -------- | ---------------------- | --------------------------- |
  | private  |         no             |          no                 |
  | public   |         yes            |         yes                 |
  | default  |         yes            |          no                 |
  | protected|         yes            |     only if extend class    |  
  
+ `final` keyword
  - can be assigned to variable, method, class, object
  - if assigned
    - variable: behave like a constant and cannot change value
    - method: cannot be overridden in its child class
    - class: no other class can extend it
    - object: only instantiated once

+ `synchronized` keyword
   - provide lock on the object and prevent race condition
   - can be applied to static/non-static methods or block of code
   - only one thread at a time can access synchronized methods
   - if multiple threads, need to wait for execution complete
   
+ `volatile` keyword
   - volatile variable stored in main memory
   - every thread can access 
   - local copy updated from main memory
   - has performance issues
   
+ `static` variable
   - `static` cannot be used for class
   - everything declared as `static` is related to class not object
   - multiple objects of a class share the same instance of static variable
   
+ `static` method
   - can be accessed without creating the objects
   - use class name to access static method
   - static method can only access static variables and not local or global non-static variable: because if the class is not instantiated and therefore the variables are not initialized and cannot be accessed from a static method
   - static method can only call static methods and not non-static methods
   - non-static methods can call static methods
   
+ static class
  - class cannot be declared as static
  - class is static if all variables and methods are static and constructor is private, so the only way to access is to use class name 

+ `throw` keyword
  - throw exception manually
  - used when program fails the condition and wants to give warning
  - throw the exception from a method to the calling method
  - calling method can decide to handle exception or throw to its calling method

  
  
<a name="Concepts"/>

## Concepts
+ object vs. class
  - an object is an instance of a class
    + object refers to an actual instance of a class
    + every object must belong to a class
    + objects are created and then destroyed, only live in the program for limited time
  - objects have a lifespan but classes do not
    + properties of objects can change while they live
  
+ `static` and `instance` method
   - instance method
     - belong to the instance of a class and require the instance before it can be called
     - dynamic binding
     - JVM selects the method to invoke based on the type of object reference, known at run time 
   - static method
     - belong to the class itself
     - static binding 
     - JVM selects the method to invoke based on the actual class of the object, known at compile time
     
+ `abstract` class and `interface`
   - abstract class
     + contain at least one abstract method
     + can contain numbers of concrete methods
     + variable can be `public`, `private`,`protected`, `default`, or constants
     + a class can only extend one abstract class
     + not compulsory to implement all methods
     + if want to add a new feature, simply implement in the abstract class and call it from subclass
   - interface
     + only contain abstract methods
     + variable is by default `public final`, only has constants
     + a class can implement multiple interfaces
     + compulsory to implement all methods
     + if want to add a new feature, need to implement the method in all classes implementing the interface
     
+ `instanceof` and `isInstance(Object obj)`
   - `instacneof` is a keyword but `isInstance()` is a method
   - `instanceof` check whether the object is type of particular class or subclass
   - `isInstance()` only used to identify if object is of a particular class
   
+ pass by value and pass by reference
  - Java only supports pass by value, actual value is passed
  - Java passes the references by value, the pointer to the object is passed as value
  - references passed to the method are actually copies of the original references
  
+ `==` and `equals()`
  - `==` is used to compare the references of the objects
  - `equals()` can compare the values of two objects
  
+ `StringBuffer` and `StringBuild`
  - `StringBuffer` is synchronized but `StringBuild` is not
  
+ `final`, `finally`,`finalize()`
  - `final`: a final variable acts like constant, a final method cannot be overridden, a final class is immutable
  - `finally`: handles exception, clean up after try block
  - `finalize()`: method helps in garbage collection, invoked before an object is discarded by the garbage collector, allowing it to clean up its state
  
+ static block and init block
  - static block is loaded when class is loaded by JVM for the first time
  - init block is loaded every time the class is loaded
+ object reflections
  - provide a way to get reflective information of class and object
  - perform operations such as
    + get information about methods and fields present inside the class at runtime
    + get a new instance of a class
    + get and set object fields directly by getting field reference, regardless what the access modifier is
  - advantage
    + help in observing or manipulating runtime behavior
    + help in debugging or testing programs
    + can call method by name when we do not know the method in advance  
  
  
<a name="OOP"/>

## OOP
+ polymorphism
  - define more than one function with the same name
  - compile time polymorphism(overloading) and runtime polymorphism(overriding)
  - method override: a class method has same name and signature as a method in parent class, JVM determines the proper method to call at runtime
  - method overloading: method with same name but different signature, determined at compile time
  
+ inheritance
  - allow a child class to inherit some properties from its parent class
  - use `extends` keyword
  - only public and protected access modifiers can be accessed in child class
  
+ multiple inheritance
  - Java does not support multiple inheritance
  - diamond problem
  - use of multiple interfaces (or extend a class and implement some interfaces)
  
    ```
      interface A{
         add();
      }
      interface B{
         add();
      }
      class C implements A,B{
         add();
      }
     ```
+ abstraction
  - convert real world objects in terms of class
  
+ encapsulation
  - achieved by combining the methods and attribute into a class
  - class acting like a container encapsulation the properties
  - hide how things work and expose the user requests
  

<a name="Collections"/>

## Collections
+ ArrayList and vector
  - synchronization
    + ArrayList is not thread-safe but vector is 
    + each method in vector class is surrounded by a synchronized block
  - data growth
    + both use arrays to store contents
    + enlarge array if not enough space
  - performance
    + vector is slower than arraylist because of thread-safe
    
+ Sort objects in lists
  - implement Comparable interface for the object class and override compareTo() method
  - if object class is a jar file, create Comparator and override compare() method
  - call Collection.sort()
  
+ HashMap and HashTable
  - HashMap is not synchronized but HashTable is
  - use Iterator for HashMap(fail-safe) and enumerator for Hashtable(not fail-safe)
  - HashMap allows null values and only one null key; Hashtable does not allow null key or null value
  
+ List interface
  - ArrayList
    + resizable array implementation
    + dynamic size
    + not thread-safe
  - Vector
    + ArrayList implementation
    + thread-safe
  - LinkedList
    + also implements Queue interface
    + FIFO
    + faster for insertion and deletion
    
+ Set interface
  - SortedSet
    + interface extends Set
    + allow data to be sorted
    + all elements inserted must implement Comparator or Comparable interface
  - TreeSet
    + implementation of SortedSet interface
    + O(logn) time for add, remove, contains operations
    + not synchronized
  - HashSet
    + implements Set interface
    + back up by hash table
    + no guarantee on constant order
    + allow null element
    + O(1) time for add,remove,contains
    
+ Arrays and ArrayList
  - arrays are fixed size but ArrayLists are dynamic
  - elements in the array list can be added or removed at runtime
  - array contains elements of same type but arraylist can contain elements of different type
  
+ ArrayList and LinkedList
  - both fast in insertion, inserting into arraylist and into first position of linkedlist takes O(1) time
  - random lookup in ArrayList is fast, but slow for LinkedList
  - remove is slow for ArrayList(elements need to be shifted) but fast for LinkedList
  
+ Advantage of iterator
   - used when no clue about object type
   - iterator allows updates
   
+ Preferred declaration
  - `List<String> list = new ArrayList<String>()` not `ArrayList<String> list = new ArrayList<String>()`
  - because function may take List as parameter
  - more flexible
  
+ Iterator access and index access
  - insert,update,or delete is faster for iterator access for elements in between the structure
  - insert,update,or delete is faster for index access for elements at the end
  - search is fast for index access
  

<a name="Thread" />

## Threading

+ Thread vs. Process
  - definition
    + process: executing instance of an application
    + thread: a path of execution within a process
  - relationship
    + a process can contain multiple threads
    + thread considered as lightweight process
  - comparison
    + thread for small tasks, process for heavy tasks
    + thread within the same process share the same address space(allow threads to read and write data to the same structures and variables, allow communication between threads), but different processes do not
    + threads are easier to create than processes because they do not require a separate address space
    + multi-threading: be careful that threads share structures that should be modified by one thread at a time
    + processes are independent of each other




# Basic Comparisons

- [LinkedList vs ArrayList](#list)
- [HashMap vs. TreeMap vs. HashTable vs. LinkedHashMap](#map)
- [Set vs. List vs. Map](#setlistmap)
- [BST vs. HashTable](#search)
- [BFS vs. DFS](#graph)
- [Graph vs. Tree](#treegraph)


<a name="list" />

## Linkedlist vs. Arraylist vs. Vector

+ Operations
  - LinkedList
    + get(index): O(n)
    + add(element): O(1)
    + add(index, element): O(n)
    + remove(index): O(n)
    + Iterator.remove(): O(1), main benefit
    + Iterator.add(element): O(1), main benefit
  - ArrayList
    + get(index): O(1), main benefit
    + add(element): O(1) amortized, worst case O(n) because need to resize array and copy
    + add(index, element): O(n-index) amortized, worst case O(n)
    + remove(index): O(n-index), remove last is O(1)
    + Iterator.remove(): O(n-index)
    + Iterator.add(element): O(n-index)

+ Compare
  - Linkedlist
     + O(1) time insertions or removals using iterator, but only sequential access
     + finding a position in the linkedlist takes time O(n)
     + each element of linkedlist have more memory overhead because pointers need to be stored
     + linkedlist also implements queue interface which adds more methods such as offer(), peek(), poll()
  - Arraylist
     + fast random read access in O(1)
     + adding or removing element except at the end require shifting latter elements, if add more elements, need to allocate new array and copy old values
     + iterating over arraylist is technically faster
     + to avoid overhead of resizing, construct arraylist with initial capacity

+ Similarities
  - both are implementation of list interface
  - maintain elements in insertion order
  - non-synchronized, but can be made synchronized explicitly
  - if list is structurally modified after iterator is created, except through iterator's own remove or add method, iterator will throw exception

+ When to use which
  - frequent addition and deletion: linkedlist
  - frequent search: arraylist
  - less memory to store many elements: arraylist

+ Vector
  - almost identical to arraylist, but is synchronized
  - more overhead because of synchronization
  - still use arraylist because they can make it synchronized explicitly



<a name="map" />

## HashMap vs. TreeMap vs. HashTable vs. LinkedHashMap

+ Overview
  - HashMap: implemented as a hash table, no ordering on keys or values
  - TreeMap: implemented based on red-black tree, ordered by key
  - LinkedHashMap: preserves insertion order
  - HashTable: synchronized in constrast to HashMap

+ HashMap
  - operation
    + put(): average O(1), worst O(n) when collision
    + get(), remove(): O(1)
  - if key is self-defined objects, need to implement equals() and hashCode()
  - iteration order not predictable
  - does not allow two identical elements
    + equals(): return true if two references refer to the same object
    + hashCode(): return distinct integers for distinct objects
  - allow null keys and values

+ TreeMap
  - operation
    + put(), get(), remove(): worst O(logn)
  - sorted by keys
  - object for key has to implement Comparable interface
  - only allow values to be null

+ HashTable
  - HashMap is roughly equivalent to HashTable, except hashmap is not synchronized and permits null

+ LinkedHashMap
  - operation: see arraylist
  - subclass of HashMap
  - linkedlist preserves the insertion order
  - allow null keys and values


<a name="setlistmap" />

## Set vs. List vs. Map

+ Set
  - unordered collection
  - unique objects (!e1.equals(e2))
  - contains at most one null

+ List
  - ordered collection(sequence)
  - access by index and search
  - may contain duplicates
  - user has control over where element inserted

+ Map
  - object that maps keys to values
  - no duplicated allowed
  - a key can map to at most one value


<a name="search" />

## BST vs. HashTable

+ BST
  - insert and retrieve: O(logn)
  - store data sorted
  - no need to know size of input in advance
  - memory efficient: do not reserve more memory than they need to

+ HashTable
  - insert and retrieve: O(1)
  - elements stored unsorted
  - with more inputs, collisions may show up
  - need more space than input data if to avoid collision
  - need to know data size, otherwise might need to resize the table


<a name="graph" />

## BFS vs. DFS

- Overview
  + search algorithms for graphs and trees
  + used for unordered graph and tree
  + graph representation
    - adjacent list: space O(V+E)
    - adjacent matrix: space O(V^2)

- BFS
  + start with root node
  + scan each node in the each level
  + while traversing each level, decide if target is found
  
- DFS
  + start with root node
  + follow on branch as far as possible until target is found or hit a leaf node
  + if hit a leaf node, continue search at the nearest ancestor


- Comparison
  + memory
    - BFS uses a large amount of memory because need to store pointers to a level(serious problem if the tree is very wide)
    - DFS uses less memory because no need to store all child pointers at a level
  + depend on the data you search for
    - look for people alive in family tree: DFS because targets are likely to be on the bottom of the tree
    - look for people who died: BFS
  + implementation
    - BFS: queue

    ```
      procedure BFS(G,v)
         initialize a queue Q
         Q.push(v)
         label v as visited
         while Q is not empty
            v <- Q.pop()
            for all edges from v to w in adjacent(v)
                if w is not visited
                   Q.push(w)
                   label w as visited
    ```

    - DFS: stack
      + recursive

        ```
          procedure DFS(G,v)
             label v as visited
             for all edges from v to w in adjacent(v)
                 if w is not visited
                     DFS(G,w)
        ```
      + iterative

        ```
           procedure DFS(G,v)
              initialize stack S
              S.push(v)
              while S is not empty
                 v <- S.pop()
                 if v is not visited
                    label v as visited
                       for all edges from v to w in adjacent(v)
                           S.push(w)
        ```
  + solution
    - BFS: complete algorithm, give optimal solution
    - DFS: suboptimal solution
  + complexity
    - BFS: worst time O(V+E), worst space O(V)
    - DFS: worst time O(v+E), worst space O(V)


<a name="treegraph" />

## Tree vs. Graph

- tree is restricted form of a graph(directed acyclic graph)
- trees have direction(parent/child relationship)
- tree does not contain cycles
- in trees, a child can only have one parent



// 1. Binary Tree vs. Hashtable, and when to use which

// 2. regular expression, file parser
regular expression for phone numbers(\d{3}\-\d{3}\-\d{4})

// 3. arraylist vs. linkedlist

// 4. hashmap vs. treemap

// 5. DFS vs. BFS

// 6. interface vs. abstract class

// 7. linux grep, find target in files

// 8. explain hashmap

// 9. hashtable knowledge, time complexity

// 10. set vs. map

// 11. tree traversal

// 12. find duplicate integer in large files: cat,sort,unique,diff

// 13. object oriented

// 14. vector vs. linkedlist

// 15. interface

16. why amazon

// 17. hashtable, hash function, collision

// 18. binary search tree

// 19. priority queue

// 20. hashmap insert,get

// 21. difference between map and list
     when to use list or map

// 22. process vs. thread

// 23. lock, dead lock

// 24. what will happen if there are too many locks in program

// 25. design patter (singleton, factory)

// 26. object vs. class

// 27. polymorphism, encapsulation

// 28. vector vs. map  and time complexity

// 29. implement map insert(), find()

// 30. many elements have same hashcode in hashmap: linear chaining, probing

// 31. priority queue: how to implement, insert, get time, O(k) space:how to add elements

// 32. hashtable: time complexity, how to store in memory

1. design library, track records of books, CDs (cc150)

2. chess game

http://amitcodes.com/2014/02/04/object-oriented-design-for-chess-game/

http://stackoverflow.com/questions/4168002/object-oriented-design-for-a-chess-game

3. hotel management system (similar to online reader system in cc150, libary contains rooms, active room, active user)

4. online booking system (cc150)

5. animal kingdom, animal zoo

6. file system (cc150)

7. deck (cc150, or deck.java)

8. wallet

9. design hashtable (cc150)




