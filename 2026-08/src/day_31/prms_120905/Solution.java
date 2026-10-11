package day_31.prms_120905;

import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist).filter(x -> x % n == 0).toArray();
    }
}
