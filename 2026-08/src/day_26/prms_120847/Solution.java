package day_26.prms_120847;

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 2] * numbers[numbers.length - 1];
    }
}
