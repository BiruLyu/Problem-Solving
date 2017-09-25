# In Java 8 – How to sort a Map?

![](http://cdn.crunchify.com/wp-content/uploads/2016/09/Best-way-to-sort-HashMap-by-Key-and-Value-in-Java8.png)

On Crunchify we have written almost ~400 java tutorials and this one is an addition to Java8 category.I love Java collection and have multiple tutorials on How to iterate through Map and List, LinkedList, JSONArray and lot more.In this tutorial we will go over Best way to sort HashMap by Key and Value in Java8.

Let’s get started:
1. We will create class `CrunchifySortMapByKeyValueJava8.java`
2. Create `HashMap<String, Integer> crunchifyMap` and that’s what we will use for sort by Key and Value.
3. 
+ For KEY: we are going to add random company from list
  + Patter: Random Number between 1 to 10 + (-) + 1 company from list
  + companies list: crunchify.com, google.com, twitter.com4
+ For VALUE:  we are going to add one random number between 1 to 505	
We will print original Map, Sorted by Key Map and Sorted by Value `MapMap.Entry.comparingByKey()` returns a comparator that compares `Map.Entry` in natural order on `key.Map.Entry.comparingByValue()` returns a comparator that compares `Map.Entry` in natural order on value.

# Here is a complete Java code:

Please take a look at [two questions](http://crunchify.com/top-10-java-interview-questions-answers-must-read-before-appearing-for-any-java-interview/) mentioned in below code carefully 🙂 These are [simple utilities](http://crunchify.com/how-to-create-zip-or-tar-programatically-in-java-using-apache-commons-archivers-and-compressors/) just incase if you want to use it in your project.
+ How to get Random value from [ArrayList](http://crunchify.com/how-to-convert-hashmap-to-arraylist-in-java/)?
+ How to Iterate through HashMap in [Java 8](http://crunchify.com/java-8-stream-operations-and-lambda-expression-tutorial/)?

``` java

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;
 
/**
 * @author Crunchify.com
 * 
 *         Best way to sort HashMap by Key and Value in Java8 - Tutorial by App Shah
 * 
 */
 
public class CrunchifySortMapByKeyValueJava8 {
 
	private static Random crunchifyRandom = new Random();
 
	public static void main(String[] argv) {
 
		Map<String, Integer> crunchifyMap = new HashMap<>();
 
		// Let's first create companies ArrayList
		ArrayList<String> companies = new ArrayList<>();
		companies.add("Crunchify.com");
		companies.add("Google.com");
		companies.add("Twitter.com");
 
		// Let's add 10 entries to HashMap crunchifyMap
		for (int i = 1; i <= 10; ++i) {
 
			// How to get Random value from ArrayList?
			String company = companies.get(crunchifyRandom.nextInt(companies.size()));
 
			// Basically we are creating
			// Key with pattern: 1-Crunchify, 5-Google, and so on...
			// Random Value: Number between 1 to 50
			crunchifyMap.put(crunchifyRandom.nextInt(10) + "-" + company, crunchifyRandom.nextInt(50));
		}
 
		log("~~~~~~~~~~~~~~Original HashMap (crunchifyMap value)~~~~~~~~~~~~~~");
		log(crunchifyMap);
 
		log("\n~~~~~~~~~~~~~~Updated HashMap after Sorting by Key~~~~~~~~~~~~~~");
		Map<String, Integer> key = crunchifySortByKey(crunchifyMap);
		iterateThroughHashMapJava8(key);
 
		log("\n~~~~~~~~~~~~~~Updated HashMap after Sorting by Value~~~~~~~~~~~~~~");
		Map<String, Integer> value = crunchifySortByValue(crunchifyMap);
		iterateThroughHashMapJava8(value);
 
	}
 
	// Simple Log Statement
	private static void log(Object string) {
		System.out.println(string);
	}
 
	// How to Iterate through HashMap in Java 8?
	private static void iterateThroughHashMapJava8(Map<String, Integer> crunchifyMap) {
		crunchifyMap.forEach((k, v) -> {
			System.out.println("Key: " + k + "\t\t Value: " + v);
		});
 
	}
 
	// Let's sort HashMap by Key
	public static <K extends Comparable<? super K>, V> Map<K, V> crunchifySortByKey(Map<K, V> crunchifyMap) {
 
		Map<K, V> crunchifyResult = new LinkedHashMap<>();
		Stream<Map.Entry<K, V>> sequentialStream = crunchifyMap.entrySet().stream();
 
		// comparingByKey() returns a comparator that compares Map.Entry in natural order on key.
		sequentialStream.sorted(Map.Entry.comparingByKey()).forEachOrdered(c -> crunchifyResult.put(c.getKey(), c.getValue()));
		return crunchifyResult;
	}
 
	// Let's sort HashMap by Value
	public static <K, V extends Comparable<? super V>> Map<K, V> crunchifySortByValue(Map<K, V> crunchifyMap) {
 
		Map<K, V> crunchifyResult = new LinkedHashMap<>();
		Stream<Map.Entry<K, V>> sequentialStream = crunchifyMap.entrySet().stream();
 
		// comparingByValue() returns a comparator that compares Map.Entry in natural order on value.
		sequentialStream.sorted(Map.Entry.comparingByValue()).forEachOrdered(c -> crunchifyResult.put(c.getKey(), c.getValue()));
		return crunchifyResult;
	}
 
}

```

# Output 

```
~~~~~~~~~~~~~~Original HashMap (crunchifyMap value)~~~~~~~~~~~~~~
{9-Crunchify.com=27, 
3-Crunchify.com=34, 
8-Twitter.com=24, 
1-Twitter.com=49, 
2-Crunchify.com=40, 
3-Twitter.com=31, 
1-Google.com=2, 
8-Google.com=16, 
8-Crunchify.com=8}

~~~~~~~~~~~~~~Updated HashMap after Sorting by Key~~~~~~~~~~~~~~
Key: 1-Google.com		 Value: 2
Key: 1-Twitter.com		 Value: 49
Key: 2-Crunchify.com		 Value: 40
Key: 3-Crunchify.com		 Value: 34
Key: 3-Twitter.com		 Value: 31
Key: 8-Crunchify.com		 Value: 8
Key: 8-Google.com		 Value: 16
Key: 8-Twitter.com		 Value: 24
Key: 9-Crunchify.com		 Value: 27

~~~~~~~~~~~~~~Updated HashMap after Sorting by Value~~~~~~~~~~~~~~
Key: 1-Google.com		 Value: 2
Key: 8-Crunchify.com		 Value: 8
Key: 8-Google.com		 Value: 16
Key: 8-Twitter.com		 Value: 24
Key: 9-Crunchify.com		 Value: 27
Key: 3-Twitter.com		 Value: 31
Key: 3-Crunchify.com		 Value: 34
Key: 2-Crunchify.com		 Value: 40
Key: 1-Twitter.com		 Value: 49
```