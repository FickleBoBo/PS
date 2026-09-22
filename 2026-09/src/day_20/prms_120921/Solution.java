package day_20.prms_120921;

class Solution {
    public int solution(String A, String B) {
        int len = A.length();
        for (int i = 0; i < len; i++) {
            if (A.equals(B)) return i;
            A = A.substring(len - 1) + A.substring(0, len - 1);
        }

        return -1;
    }
}
