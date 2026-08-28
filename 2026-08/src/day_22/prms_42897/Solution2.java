package day_22.prms_42897;

class Solution2 {
    public int solution(int[] money) {
        int n = money.length;

        int case1 = func(money, 0, n - 1);
        int case2 = func(money, 1, n);
        return Math.max(case1, case2);
    }

    static int func(int[] money, int start, int end) {
        int prv2 = 0, prv1 = 0;

        for (int i = start; i < end; i++) {
            int cur = Math.max(prv1, prv2 + money[i]);
            prv2 = prv1;
            prv1 = cur;
        }

        return prv1;
    }
}
