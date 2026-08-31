package day_31.prms_120899;

class Solution {
    public int[] solution(int[] array) {
        int max = -1, idx = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                idx = i;
            }
        }

        return new int[]{max, idx};
    }
}
