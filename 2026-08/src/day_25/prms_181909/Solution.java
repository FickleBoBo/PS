package day_25.prms_181909;

import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        int n = my_string.length();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = my_string.substring(i);
        }
        Arrays.sort(arr);

        return arr;
    }
}
