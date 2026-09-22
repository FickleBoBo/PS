package day_20.prms_181854;

class Solution {
    public int[] solution(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length % 2 != i % 2) arr[i] += n;
        }

        return arr;
    }
}
