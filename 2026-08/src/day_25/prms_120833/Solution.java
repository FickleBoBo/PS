package day_25.prms_120833;

class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] ans = new int[num2 - num1 + 1];
        System.arraycopy(numbers, num1, ans, 0, num2 - num1 + 1);
        return ans;
    }
}
