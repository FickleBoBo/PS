package day_20.prms_181856;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return 1;
        if (arr1.length < arr2.length) return -1;

        int sum1 = 0, sum2 = 0;
        for (int x : arr1) {
            sum1 += x;
        }
        for (int x : arr2) {
            sum2 += x;
        }

        return Integer.compare(sum1, sum2);
    }
}
