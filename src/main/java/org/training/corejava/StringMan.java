package org.training.corejava;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringMan {

    public static void countChars(String A) {

        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < A.length(); i++) {
            if (!mp.containsKey(A.charAt(i))) {
                mp.put(A.charAt(i), 1);
            } else {
                mp.put(A.charAt(i), mp.get(A.charAt(i)) + 1);
            }
        }

        String result = mp.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))  // Sort by frequency in descending order
                .map(entry -> entry.getValue() + "" + entry.getKey())  // Map to "<count><char>" format
                .collect(Collectors.joining());

        System.out.println(result);

    }

    public static void countChars1(String A) {
        // Create a map to count the occurrences of each character
        Map<Character, Integer> mp = new HashMap<>();
        for (char c : A.toCharArray()) {
            mp.merge(c, 1, Integer::sum);  // Merge the count, adding 1 to the existing value
        }

        // Build the result string by sorting characters by frequency in descending order
        String result = mp.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))  // Sort by frequency in descending order
                .map(entry -> entry.getValue() + "" + entry.getKey())  // Format as "<count><char>"
                .collect(Collectors.joining());  // Join all parts into a single string

        // Print the result
        System.out.println(result);
    }

    public static void main(String[] args) {

        countChars1("bbbbaaaccee");


    }
}
