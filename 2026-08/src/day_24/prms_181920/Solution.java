package day_24.prms_181920;

class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] arr = new int[end_num - start_num + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = start_num + i;
        }

        return arr;
    }
}
