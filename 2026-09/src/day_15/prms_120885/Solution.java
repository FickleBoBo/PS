package day_15.prms_120885;

class Solution {
    public String solution(String bin1, String bin2) {
        int x1 = Integer.parseInt(bin1, 2);
        int x2 = Integer.parseInt(bin2, 2);
        return Integer.toBinaryString(x1 + x2);
    }
}
