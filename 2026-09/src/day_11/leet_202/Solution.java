package day_11.leet_202;

import java.util.*;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (!seen.contains(n)) {
            seen.add(n);
            n = step(n);
        }

        return n == 1;
    }

    static int step(int x) {
        int sum = 0;
        while (x > 0) {
            int d = x % 10;
            sum += d * d;
            x /= 10;
        }

        return sum;
    }
}
