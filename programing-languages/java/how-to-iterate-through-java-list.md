# How to iterate through Java List? Five \(5\) ways to Iterate Through Loop in Java

There are 5 ways you can iterate through List.  
1. For Loop  
2. Advanced For Loop  
3. Iterator  
4. While Loop  
5. Collections’s stream\(\) util \(Java8\)

Java Example:

You need JDK 8 to run below program as `point-5` above uses `stream()` util.  
void `java.util.stream.Stream.forEach(Consumer<? super String> action)` performs an action for each element of this stream.

## Code

```java
package crunchify.com.tutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * @author Crunchify.com
 */
public class CrunchifyIterateThroughList {

    public static void main(String[] argv) {
        // create list
        List<String> crunchifyList = new ArrayList<String>();

        // add 4 different values to list
        crunchifyList.add("eBay");
        crunchifyList.add("Paypal");
        crunchifyList.add("Google");
        crunchifyList.add("Yahoo");

        // iterate via "for loop"
        System.out.println("==> For Loop Example.");
        for (int i = 0; i < crunchifyList.size(); i++) {
            System.out.println(crunchifyList.get(i));
        }

        // iterate via "New way to loop"
        System.out.println("\n==> Advance For Loop Example..");
        for (String temp : crunchifyList) {
            System.out.println(temp);
        }

        // iterate via "iterator loop"
        System.out.println("\n==> Iterator Example...");
        Iterator<String> crunchifyIterator = crunchifyList.iterator();
        while (crunchifyIterator.hasNext()) {
            System.out.println(crunchifyIterator.next());
        }

        // iterate via "while loop"
        System.out.println("\n==> While Loop Example....");
        int i = 0;
        while (i < crunchifyList.size()) {
            System.out.println(crunchifyList.get(i));
            i++;
        }

        // collection stream() util: Returns a sequential Stream with this collection as its source
        System.out.println("\n==> collection stream() util....");
        crunchifyList.forEach((temp) -> { System.out.println(temp);});
    }
}
```

## Output

```
==> For Loop Example.
eBay
Paypal
Google
Yahoo

==> Advance For Loop Example..
eBay
Paypal
Google
Yahoo

==> Iterator Example...
eBay
Paypal
Google
Yahoo

==> While Loop Example....
eBay
Paypal
Google
Yahoo

==> collection stream() util....
eBay
Paypal
Google
Yahoo
```

# [Iterate through a HashMap \[duplicate\]](https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap/1066603#1066603)

Iterate through the `entrySet` like so:

```java
public static void printMap(Map mp) {
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }
}
```

Read more on [`Map`](http://docs.oracle.com/javase/7/docs/api/java/util/Map.html)

```java
Map<String, Object> map = ...;
for (String key : map.keySet()) {
    // ...
}
```

If you only need the values, use `values()`:

```java
for (Object value : map.values()) {
    // ...
}
```

Finally, if you want both the key and value, use `entrySet()`:

```java
for (Map.Entry<String, Object> entry : map.entrySet()) {
    String key = entry.getKey();
    Object value = entry.getValue();
    // ...
}
```

One caveat: if you want to remove items mid-iteration, you'll need to do so via an Iterator \(see [karim79's answer](https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap/1066603#1066603)\). However, changing item values is OK \(see [Map.Entry](http://docs.oracle.com/javase/6/docs/api/java/util/Map.Entry.html)\).


# How to convert HashMap to ArrayList in Java?

``` java
package com.crunchify;
 
/**
 * @author Crunchify.com
 */
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;	
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
 
public class CrunchifyHashmapToArrayList {
 
	public static void main(String... args) {
		HashMap<String, Integer> companyDetails = new HashMap<String, Integer>();
 
		// create hashmap with keys and values (CompanyName, #Employees)
		companyDetails.put("eBay", 4444);
		companyDetails.put("Paypal", 5555);
		companyDetails.put("IBM", 6666);
		companyDetails.put("Google", 7777);
		companyDetails.put("Yahoo", 8888);
 
		System.out.println("==> Size of companyDetails Map: " + companyDetails.size());
		Iterator it = companyDetails.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.println(pairs.getKey() + " = " + pairs.getValue());
		}
 
		// Converting HashMap keys into ArrayList
		List<String> keyList = new ArrayList<String>(companyDetails.keySet());
		System.out.println("\n==> Size of Key list: " + keyList.size());
 
		for (String temp : keyList) {
			System.out.println(temp);
		}
 
		// Converting HashMap Values into ArrayList
		List<Integer> valueList = new ArrayList<Integer>(companyDetails.values());
		System.out.println("\n==> Size of Value list: " + valueList.size());
		for (Integer temp : valueList) {
			System.out.println(temp);
		}
 
		List<Entry> entryList = new ArrayList<Entry>(companyDetails.entrySet());
		System.out.println("\n==> Size of Entry list: " + entryList.size());
		for (Entry temp : entryList) {
			System.out.println(temp);
		}
	}
}

```
