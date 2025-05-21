package org.training.java8;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {

        Set<String> st = new HashSet<>();
        Collections.addAll(st,names1);
        Collections.addAll(st,names2);

        String[] myArray = new String[st.size()];
        st.toArray(myArray);


        return myArray ;

    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
