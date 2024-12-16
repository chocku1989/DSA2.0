package org.training;

import java.util.HashSet;

public class PanagramCheck {

    public static int solve(String[] sentenceArray) {

        for (int i = 0; i <= 25; i++) {
            int currChar = i + 'a';
            boolean result = false;
            for (int j = 0; j < sentenceArray.length; j++) {

                for (int k = 0; k < sentenceArray[j].length(); k++) {
                    if (sentenceArray[j].charAt(k) == currChar) {
                        result = true;
                        break;
                    }
                }
                if (result) {
                    break;
                }
            }
            if (!result) return 0;

        }

        return 1;
    }

    /*this can be done via hasing as well */

    public static int solveByHashing(String[] sentenceArray) {

        boolean result = false;
        HashSet<Character> st = new HashSet<>();
        for (int j = 0; j < sentenceArray.length; j++) {
            for (int k = 0; k < sentenceArray[j].length(); k++) {
                st.add(sentenceArray[j].charAt(k));
            }
        }
        if (st.size() == 26) return 1;
        return 0;
    }


    public static void main(String[] args) {
        String[] ipArr = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lay", "dog"};
        System.out.println(solveByHashing(ipArr));
    }

}