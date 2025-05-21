package org.training.arrays;

import java.util.ArrayList;
import java.util.ListIterator;

public class AddOne {
    public ArrayList<Integer> plusOne(ArrayList<Integer> arrList) {

        boolean carryOver = false;

        for (int i = arrList.size() - 1; i >= 0; i--) {

            if ((arrList.get(i) + 1) < 10) {
                arrList.set(i, arrList.get(i) + 1);
                carryOver = false;
                break;
            } else {
                arrList.set(i, 0);
                carryOver = true;
            }

        }

        if (carryOver) {
            arrList.add(0, 1);
        }

        ListIterator<Integer> iter = arrList.listIterator();
        while (iter.hasNext()) {
            if (iter.next() > 0) {
                break;
            } else {
                iter.remove();
            }
        }
        return arrList;
    }
}
