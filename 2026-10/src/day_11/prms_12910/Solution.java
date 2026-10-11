package day_11.prms_12910;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] ans = Arrays.stream(arr).filter(x -> x % divisor == 0).sorted().toArray();
        if (ans.length == 0) return new int[]{-1};
        return ans;
    }
}
