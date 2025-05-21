package org.training;

import java.util.ArrayDeque;
import java.util.Deque;

public class LearnQueue {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        deque.add(2);
        deque.addFirst(3);
//        int first = deque.removeFirst();
//        int last = deque.removeLast();
//        System.out.println("First: " + first + ", Last: " + last);

        System.out.println("removed element " +deque.poll());

        for(Integer s : deque) {
            System.out.println(s);
        }
    }
}
