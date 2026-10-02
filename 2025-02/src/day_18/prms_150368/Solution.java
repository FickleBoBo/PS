package day_18.PRMS_150368;

class Solution {

    private static int N;
    private static int M;
    private static int[] sumArr;
    private static final int[] ans = new int[2];

    public int[] solution(int[][] users, int[] emoticons) {
        N = users.length;
        M = emoticons.length;
        sumArr = new int[N];

        permutation(0, users, emoticons);

        return ans;
    }

    // 중복 순열
    private static void permutation(int selIdx, int[][] users, int[] emoticons) {
        if (selIdx == M) {
            int cnt = 0;  // 이모티콘 플러스 가입자 수
            int sum = 0;  // 이모티콘 판매액

            for (int i = 0; i < N; i++) {
                if (sumArr[i] >= users[i][1]) cnt++;
                else sum += sumArr[i];
            }

            if (cnt > ans[0]) {
                ans[0] = cnt;
                ans[1] = sum;
            } else if (cnt == ans[0] && sum > ans[1]) {
                ans[1] = sum;
            }

            return;
        }

        for (int discount = 10; discount <= 40; discount += 10) {
            // 방문 체크
            for (int i = 0; i < N; i++) {
                if (users[i][0] <= discount) sumArr[i] += emoticons[selIdx] * (100 - discount) / 100;
            }

            permutation(selIdx + 1, users, emoticons);

            // 방문 해제
            for (int i = 0; i < N; i++) {
                if (users[i][0] <= discount) sumArr[i] -= emoticons[selIdx] * (100 - discount) / 100;
            }
        }
    }

}
