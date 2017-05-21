package crunchify.com.tutorial;
 
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
 
	public static void main(String[] args) {
 
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