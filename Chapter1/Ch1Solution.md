##Knowledge Goals

**Describe some benifits of object-oriented programming**

1. Modularity for easier troubleshooting
2. Reuse of code through inheritance
3. Flexibility through polymorphism
4. Effective problem solving

**Describe the genesis of the Unified Method**

1. In the late 1980s, many people proposed object-oriented methodologis. 
2. By the mid-1990s, three proposals stood out: the **Object Modeling Technique**, the **Objectory Process**, and the **Booch Method**.
3. Between 1994 and 1997, the primary authors of these proposals got together and consolidated their ideas. The resulting methodology was the Unified Method.

**explain the relationships among classes, objects, and applications**

* A class defines the structure of an object. 
* A class definition includes variables and methods that determine the behavior of an object.
* Objects are created from classes at run time.
* Objects can contain and manipulate data.
* The class that contains the main method is called a Java application.

**explain how method calls are bound to method implementations with respect to inheritance**

* ​

**describe, at an abstract level, the following structures: array, linked list, stack, queue, list, tree, map, and graph**

1. **array:**  is a [data structure](https://en.wikipedia.org/wiki/Data_structure) consisting of a collection of *elements* ([values](https://en.wikipedia.org/wiki/Value_(computer_science)) or [variables](https://en.wikipedia.org/wiki/Variable_(programming))), each identified by at least one *array index* or *key*. 
2. **linked list:** is a linear collection of data elements, in which linear order is not given by their physical placement in memory. Each pointing to the next node by means of a [pointer](https://en.wikipedia.org/wiki/Pointer_(computer_programming)). It is a [data structure](https://en.wikipedia.org/wiki/Data_structure) consisting of a group of [nodes](https://en.wikipedia.org/wiki/Node_(computer_science)) which together represent a [sequence](https://en.wikipedia.org/wiki/Sequence).
3. **stack:** is an access-controlled structure in which elements are added or removed from only one end, a LIFO structure. pop, push, top.
4. **queue:**  is an access-controlled group of elements in which new elements are added at one end (the "rear") and elements are removed from the other end (the "front"). enqueue, dequeue.
5. **list:** is an [abstract data type](https://en.wikipedia.org/wiki/Abstract_data_type) that represents a countable number of ordered [values](https://en.wikipedia.org/wiki/Value_(computer_science)), where the same value may occur more than once.
6. **tree:** is a widely used [abstract data type](https://en.wikipedia.org/wiki/Abstract_data_type) (ADT)—or [data structure](https://en.wikipedia.org/wiki/Data_structure) implementing this ADT—that simulates a hierarchical [tree structure](https://en.wikipedia.org/wiki/Tree_structure), with a root value and [subtrees](https://en.wikipedia.org/wiki/Subtrees) of children with a parent node, represented as a set of linked [nodes](https://en.wikipedia.org/wiki/Vertex_(graph_theory)).
7. **map::** is an [abstract data type](https://en.wikipedia.org/wiki/Abstract_data_type) composed of a [collection](https://en.wikipedia.org/wiki/Collection_(computing)) of [(key, value)](https://en.wikipedia.org/wiki/Attribute%E2%80%93value_pair) pairs, such that each possible key appears at most once in the collection.
8. **graph:** is an [abstract data type](https://en.wikipedia.org/wiki/Abstract_data_type) that is meant to implement the [undirected graph](https://en.wikipedia.org/wiki/Graph_(discrete_mathematics)) and [directed graph](https://en.wikipedia.org/wiki/Directed_graph) concepts from [mathematics](https://en.wikipedia.org/wiki/Mathematics), specifically the field of [graph theory](https://en.wikipedia.org/wiki/Graph_theory).

**explain the subtle ramifications of using references/pointers**



**explain the use of O notation to describe the amount of work done by an algorithm**

* Computer scientists take advantage of the fact that what really matters when comparing algorithms is the highest order of the polynomial that represents the number of steps needed. 
* The order is to describe the efficiency.
* It is "Oder of Growth *N*"

**describe the sequential search, binary search, and selection sort algorithms**

* A [sequential search](http://en.wikipedia.org/wiki/Linear_search) looks down a list, one item at a time, without jumping. In complexity terms this is an `O(N)` search - the time taken to search the list gets bigger at the same rate as the list does.
* A [binary search](http://en.wikipedia.org/wiki/Binary_search) is when you start with the middle of a sorted list, and see whether that's greater than or less than the value you're looking for, which determines whether the value is in the first or second half of the list. Jump to the half way through the sublist, and compare again etc. 
* A [selection sort](https://en.wikipedia.org/wiki/Selection_sort) is given an unsorted list of elements, the algorithm scans through the list and finds the smallest elements. I then selects that element and swaps is with the first element.Next it scans the list again to find the second smallest element, again selecting it and swqpping it with the second element.




## Skill Goals

**interpret a basic UML class diagram**

**design and implement a Java class**

```java
package ch01.dates;

public class Date
{
  protected int year, month, day;
  public static final int MINYEAR = 1583;

  // Constructor
  public Date(int newMonth, int newDay, int newYear)
  {
    month = newMonth;  day = newDay;  year = newYear;
   }

  // Observers
  public int getYear() { return year;  }
  public int getMonth(){ return month; }
  public int getDay()  { return day;   }
  
  public int lilian()
  {
    // Returns the Lilian Day Number of this date.
    // Precondition: This Date is a valid date after 10/14/1582.
    //
    // Computes the number of days between 1/1/0 and this date as if no calendar
    // reforms took place, then subtracts 578,100 so that October 15, 1582 is day 1. 
    
    final int subDays = 578100;  // number of calculated days from 1/1/0 to 10/14/1582

    int numDays = 0;

    // Add days in years.
    numDays = year * 365;

    // Add days in the months.
    if (month <= 2) 
      numDays = numDays + (month - 1) * 31;
    else 
      numDays = numDays + ((month - 1) * 31) - ((4 * (month-1) + 27) / 10);

    // Add days in the days.
    numDays = numDays + day;

    // Take care of leap years.
    numDays = numDays + (year / 4) - (year / 100) + (year / 400);

    // Handle special case of leap year but not yet leap day.
    if (month < 3) 
    {
        if ((year % 4) == 0)   numDays = numDays - 1;
        if ((year % 100) == 0) numDays = numDays + 1;
        if ((year % 400) == 0) numDays = numDays - 1;
    }

    // Subtract extra days up to 10/14/1582.
    numDays = numDays - subDays;
    return numDays;
  }
  
  @Override
  public String toString()
  // Returns this date as a String.
  {
    return(month + "/" + day + "/" + year);
  }
}
```

**create a Java application that uses the Java class**

```java
package ch01.apps;

import java.util.Random;
import java.text.DecimalFormat;

public class SelSortAndBinSearch
{
  static final int SIZE = 100;   // size of array to be searched
  static int[] values = new int[SIZE];   // values to be sorted

  static void initValues()
  // Initializes the values array with random integers from 0 to SIZE.
  {
    Random rand = new Random();
    for (int index = 0; index < SIZE; index++)
      values[index] = Math.abs(rand.nextInt()) % SIZE;
  }

  static public boolean isSorted()
  // Returns true if the array values are sorted and false otherwise.
  {
    boolean sorted = true;
    for (int index = 0; index < (SIZE - 1); index++)
      if (values[index] > values[index + 1])
        sorted = false;
    return sorted;
  }

  static public void swap(int index1, int index2)
  // Precondition: index1 and index2 are >= 0 and < SIZE.
  //
  // Swaps the integers at locations index1 and index2 of the values array. 
  {
    int temp = values[index1];
    values[index1] = values[index2];
    values[index2] = temp;
  }

  static public void printValues()
  // Prints all the values integers.
  {
    int value;
    DecimalFormat fmt = new DecimalFormat("000");
    System.out.println("The values array is:");
    for (int index = 0; index < SIZE; index++)
    {
      value = values[index];
      if (((index + 1) % 10) == 0)
        System.out.println(fmt.format(value));
      else
        System.out.print(fmt.format(value) + " ");
    }
    System.out.println();
  }

  /////////////////////////////////////////////////////////////////
  //
  //  Selection Sort

  static int minIndex(int startIndex, int endIndex)
  // Returns the index of the smallest value in
  // values[startIndex]..values[endIndex].
  {
    int indexOfMin = startIndex;
    for (int index = startIndex + 1; index <= endIndex; index++)
      if (values[index] < values[indexOfMin])
        indexOfMin = index;
    return indexOfMin;
  }

  static void selectionSort()
  // Sorts the values array using the selection sort algorithm.
  {
    int endIndex = SIZE - 1;
    for (int current = 0; current < endIndex; current++)
      swap(current, minIndex(current, endIndex));
  }

  //
  //  Selection Sort End
  /////////////////////////////////////////////////////////////////


  static boolean binarySearch(int target, int first, int last)
  // Preconditions: first and last are legal indices of values
  //                first + last <= Integer.MAX_Value
  //
  // If target is contained in values[first,last] return true
  // otherwise return false
  {
    int midpoint;
    while (first <= last)
    {
      midpoint = (first + last) / 2;
      if (target == values[midpoint])
        return true;
      else
      if (target > values[midpoint])  // target too high
        first = midpoint + 1;
      else                            // target too low
        last = midpoint - 1;
    }
    return false;
  }

 
  /////////////////////////////////////////////////////////////////
  //
  //  Main

  public static void main(String[] args)
  {
    initValues();
    printValues();
    System.out.println("values is sorted: " + isSorted());
    System.out.println();    
    selectionSort();
    printValues();
    System.out.println("values is sorted: " + isSorted());
    System.out.println();
    
    System.out.println("Binary Search:");
    System.out.println("0 is in array: " + binarySearch(0, 0, SIZE - 1));
    System.out.println("1 is in array: " + binarySearch(1, 0, SIZE - 1));
    for (int i = (SIZE/2 - 2); i <= (SIZE/2 + 2); i++)
      System.out.println(i + " is in array: " + binarySearch(i, 0, SIZE - 1));
    System.out.println(SIZE - 1 + " is in array: " + binarySearch(SIZE - 1, 0, SIZE - 1));
    System.out.println(SIZE + " is in array: " + binarySearch(SIZE, 0, SIZE - 1));
    System.out.println();
  }
}
```

**use packages to organize Java compilation units**

**create a Java exception class**

```java
package ch01.dates;

public class DateOutOfBoundsException extends Exception
{
  public DateOutOfBoundsException()
  {
    super();
  }

  public DateOutOfBoundsException(String message)
  {
    super(message);
  }
}
```

**throw Java exceptions from whthin a class and catch them within an application that uses the class**

```java
package ch01.dates;

public class SafeDate 
{
  protected int year, month, day;
  public static final int MINYEAR = 1583;

  public SafeDate(int newMonth, int newDay, int newYear)
                       throws DateOutOfBoundsException
  {
    if ((newMonth <= 0) || (newMonth > 12))
      throw new DateOutOfBoundsException("month " + newMonth + " illegal");
    else
      month = newMonth;  
      
    day = newDay;  
    
    if (newYear < MINYEAR)
      throw new DateOutOfBoundsException("year " + newYear + " too early");
    else    
      year = newYear;
  }

  // Observers
  public int getYear() { return year;  }
  public int getMonth(){ return month; }
  public int getDay()  { return day;   }

  public int lilian()
  {
    // Returns the Lilian Day Number of this date.
    // Precondition: This Date is a valid date after 10/14/1582.
    //
    // Computes the number of days between 1/1/0 and this date as if no calendar
    // reforms took place, then subtracts 578,100 so that October 15, 1582 is day 1. 
    
    final int subDays = 578100;  // number of calculated days from 1/1/0 to 10/14/1582

    int numDays = 0;

    // Add days in years.
    numDays = year * 365;

    // Add days in the months.
    if (month <= 2) 
      numDays = numDays + (month - 1) * 31;
    else 
      numDays = numDays + ((month - 1) * 31) - ((4 * (month-1) + 27) / 10);

    // Add days in the days.
    numDays = numDays + day;

    // Take care of leap years.
    numDays = numDays + (year / 4) - (year / 100) + (year / 400);

    // Handle special case of leap year but not yet leap day.
    if (month < 3) 
    {
        if ((year % 4) == 0)   numDays = numDays - 1;
        if ((year % 100) == 0) numDays = numDays + 1;
        if ((year % 400) == 0) numDays = numDays - 1;
      }

    // Subtract extra days up to 10/14/1582.
    numDays = numDays - subDays;
    return numDays;
  }

  @Override
  public String toString()
  // Returns this date as a String.
  {
    return(month + "/" + day + "/" + year);
  }

}
```

**predict the output of short segments of Java code that exhibit aliasing**

**declare, initialize, and use one- and two-dimensional arrays in Java, including both arrays of a primitive type and arrays of objects**

```java
int[] myOneArray = {0,1,2,3};
int[][] myTwoArray = { {0,1,2,3}, {3,2,1,0}, {3,5,6,1}, {3,8,3,4} };   
```

**given an algorithm, identify an appropriate size representation and determine its order of growth**

```java
O(1)
O(log2(N))
O(N)
O(Nlog2(N))
O(N^2)
O(2^N)
```

**given a section of code determine its order of growth**

```
"bounded time"
"logarithmic time"
"linear time"
"N log N time"
"quadratic time"
"exponential time"
```

