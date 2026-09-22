package day_22.prms_181831;

class Solution {
    public int solution(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i][j] != arr[j][i]) return 0;
            }
        }

        return 1;
    }
}
