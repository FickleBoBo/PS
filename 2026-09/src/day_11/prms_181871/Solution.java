package day_11.prms_181871;

class Solution {
    public int solution(String myString, String pat) {
        int cnt = 0;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.indexOf(pat, i) == i) cnt++;
        }

        return cnt;
    }
}
