package day_28.prms_181837;

class Solution {
    public int solution(String[] order) {
        int sum = 0;
        for (String s : order) {
            sum += s.contains("cafelatte") ? 5000 : 4500;
        }

        return sum;
    }
}
