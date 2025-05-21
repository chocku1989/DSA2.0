package org.training.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CuttingRod {
  public int solve(ArrayList<Integer> A) {
    // Handle empty or null input
    if (A == null || A.isEmpty()) {
      return 0;
    }

    int N = A.size();
    List<Integer> dpList = new ArrayList<>(Collections.nCopies(N + 1, 0));

    // Base case
    dpList.set(0, 0);
    dpList.set(1, A.get(0));

    // Build up dpList from 2 to N
    for (int i = 2; i <= N; i++) {
      for (int j = 1; j <= i; j++) {
        int maxValue = Math.max(dpList.get(i), A.get(j - 1) + dpList.get(i - j));
        dpList.set(i, maxValue);
      }
    }
    return dpList.get(N);
  }
}
