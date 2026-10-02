package day_02.PRMS_43105;

class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;

        // 특정 위치까지 이동하는데 거쳐간 숫자의 최댓값을 저장
        int[][] dp = new int[1 + N][1 + N];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {

                // 특정 위치까지 이동하는데 거쳐간 숫자의 최댓값 = 해당 위치로 오기 직전 위치까지 이동하는데 거쳐간 숫자의 최댓값 + 해당 위치의 숫자
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i - 1][j - 1];
            }
        }

        int max = 0;
        for (int num : dp[N]) {
            max = Math.max(max, num);
        }

        return max;
    }
}
