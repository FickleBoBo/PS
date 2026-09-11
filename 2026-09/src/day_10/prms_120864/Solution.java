package day_10.prms_120864;

import java.util.*;

class Solution {
    public int solution(String my_string) {
        char[] arr = my_string.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isDigit(arr[i])) arr[i] = ' ';
        }

        StringTokenizer st = new StringTokenizer(new String(arr));
        int sum = 0;
        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }

        return sum;
    }
}
