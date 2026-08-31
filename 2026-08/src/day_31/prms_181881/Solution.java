package day_31.prms_181881;

import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int[] prv = arr;
        int x = 0;

        while (true) {
            int[] cur = step(prv);

            if (Arrays.equals(prv, cur)) return x;
            prv = cur;
            x++;
        }
    }

    static int[] step(int[] arr) {
        int[] res = arr.clone();

        for (int i = 0; i < res.length; i++) {
            if (res[i] >= 50 && res[i] % 2 == 0) {
                res[i] /= 2;
            } else if (res[i] < 50 && res[i] % 2 != 0) {
                res[i] = res[i] * 2 + 1;
            }
        }

        return res;
    }
}
