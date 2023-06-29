/* Sparse Arrays */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day29 {
	public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
		List<Integer> results = new ArrayList<>();

		// Count the occurrences of each string in the input string list
		Map<String, Integer> stringCount = new HashMap<>();
		for (String str : stringList) {
			stringCount.put(str, stringCount.getOrDefault(str, 0) + 1);
		}

		// Iterate through each query string and retrieve its count from the map
		for (String query : queries) {
			int count = stringCount.getOrDefault(query, 0);
			results.add(count);
		}

		return results;
	}

	public static void main(String[] args) {
		//Day29 day = new Day29();
		List<String> stringList = new ArrayList<>();
		stringList.add("aba");
		stringList.add("baba");
		stringList.add("aba");
		stringList.add("xzxb");

		List<String> queries = new ArrayList<>();
		queries.add("aba");
		queries.add("ab");
		queries.add("xzxb");

		List<Integer> results = matchingStrings(stringList, queries);
		System.out.println(results);

	}

}
