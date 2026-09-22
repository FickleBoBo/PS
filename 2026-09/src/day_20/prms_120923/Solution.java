package day_20.prms_120923;

class Solution {
    public int[] solution(int num, int total) {
        int[] arr = new int[num];
        int a = total / num - (num - 1) / 2;
        for (int i = 0; i < num; i++) {
            arr[i] = a + i;
        }

        return arr;
    }
}
