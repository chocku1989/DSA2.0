package org.training.java8;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StringOccurrence {

    protected StringOccurrence(String s){

    }
    public static int getOccurrenceCount(String toSearch, InputStream stream) throws Exception {
        String result = new BufferedReader(new InputStreamReader(stream))
                .lines().collect(Collectors.joining("\n"));
        String[] split = result.split("\n");
        int count=0;
        for (String s : split){
            if(s.contains(toSearch)){
                count++;
            }
        }
        return count;
    }

    public static void main1(String[] args) throws Exception {
        String msg = "Hey! How are you?\nI am good, how about you?\nI am good too.";

        try(InputStream stream = new ByteArrayInputStream(msg.getBytes())) {
            System.out.println(StringOccurrence.getOccurrenceCount("good", stream));
        }
    }



        public static int findMaxSum(List<Integer> list) {

            int max1=list.get(0);
            int max2=list.get(1);

            for (int i = 2; i < list.size(); i++) {
                if(list.get(i)> max1 && list.get(i)> max2){
                    max1= Math.max(max1,max2);
                    max2=list.get(i);
                }else if((list.get(i)> max1)){
                    max1=list.get(i);
                }else if((list.get(i)< max2)){
                    max2=list.get(i);
                }
            }

            return max2+max1;



        }

        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(5, 9, 7, 11);
            // Should return 20, since 9 and 11 are the largest elements
            // and their sum is 20
            System.out.println(findMaxSum(list));
        }
    }
