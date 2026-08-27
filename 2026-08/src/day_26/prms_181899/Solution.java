package day_26.prms_181899;

class Solution {
    public int[] solution(int start_num, int end_num) {
        int[] arr = new int[start_num - end_num + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = start_num - i;
        }

        return arr;
    }
}
