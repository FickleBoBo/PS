package day_15.prms_181857;

import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int n = 1;
        while (n < arr.length) {
            n <<= 1;
        }

        return Arrays.copyOf(arr, n);
    }
}
