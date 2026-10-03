package day_20.prms_181856;

import java.util.*;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return 1;
        if (arr1.length < arr2.length) return -1;

        int sum1 = Arrays.stream(arr1).sum();
        int sum2 = Arrays.stream(arr2).sum();
        return Integer.compare(sum1, sum2);
    }
}
