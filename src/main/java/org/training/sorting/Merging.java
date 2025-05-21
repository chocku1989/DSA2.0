package org.training.sorting;

import java.util.ArrayList;

public class Merging {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        mergeSort(A, 0, A.size() - 1);
        return A;
    }

    public void mergeSort(ArrayList<Integer> A, int start, int end) {
        if (start == end) return;

        int mid = (start + end) / 2;
        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);
        merge(A, start, end, mid);

        
    }


    public void merge(ArrayList<Integer> arrList, int start, int end, int middle) {

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        int i = start;
        while (i <= middle) {
            leftList.add(arrList.get(i));
            i++;
        }

        i = middle + 1;
        while (i <= end) {
            rightList.add(arrList.get(i));
            i++;
        }


        int m = 0;
        int n = 0;
        int temp = start;

        while (m < leftList.size() && n < rightList.size()) {
            if (rightList.get(n) < leftList.get(m)) {
                arrList.set(temp++, (rightList.get(n)));
                n++;
            } else {
                arrList.set(temp++, (leftList.get(m)));
                m++;
            }
        }


        while (m < leftList.size()) {

            arrList.set(temp++, (leftList.get(m)));

            m++;
        }


        while (n < rightList.size()) {

            arrList.set(temp++, rightList.get(n));

            n++;
        }

    }
}
