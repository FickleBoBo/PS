package day_22.prms_42897;

class Solution2 {
    public int solution(int[] money) {
        int n = money.length;

        int case1 = solve(money, 0, n - 1);
        int case2 = solve(money, 1, n);
        return Math.max(case1, case2);
    }

    static int solve(int[] money, int l, int r) {
        int prv2 = 0, prv1 = 0;

        for (int i = l; i < r; i++) {
            int cur = Math.max(prv1, prv2 + money[i]);
            prv2 = prv1;
            prv1 = cur;
        }

        return prv1;
    }
}
