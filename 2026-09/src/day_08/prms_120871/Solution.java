package day_08.prms_120871;

class Solution {
    public int solution(int n) {
        int x = 0;
        int cnt = 0;
        while (cnt < n) {
            x++;
            if (x % 3 == 0 || String.valueOf(x).contains("3")) continue;
            cnt++;
        }

        return x;
    }
}
