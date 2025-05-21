package org.training.arrays;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class AmazingSubArray {
    public int solve(String A) {
        int mod = 10003;
        A = A.toUpperCase();
        char[] cArr = A.toCharArray();
        List<Character> lst = new ArrayList<>();
        for (char c : cArr) {
            lst.add(c);  // Add each character to the list
        }
        AtomicInteger count = new AtomicInteger(0);

        // Use IntStream.range to iterate over indices and handle counting
        final int length = A.length();
        IntStream.range(0, cArr.length).forEach(i -> {
            char c = cArr[i];  // Get the character at index i
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                // For each vowel, add the number of remaining characters in the string
                count.set((count.get() + (length - i)) % mod);
            }
        });
        return count.get() % mod;
    }

}
