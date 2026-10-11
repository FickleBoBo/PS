package day_11.prms_12901;

class Solution {
    public String solution(int a, int b) {
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int d = 0;
        for (int i = 1; i < a; i++) {
            d += days[i];
        }
        d += b;

        String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        return week[d % 7];
    }
}
