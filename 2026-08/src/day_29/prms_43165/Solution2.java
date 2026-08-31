package day_29.prms_43165;

class Solution2 {
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }

    static int dfs(int cur, int depth, int[] numbers, int target) {
        if (depth == numbers.length) return cur == target ? 1 : 0;

        return dfs(cur + numbers[depth], depth + 1, numbers, target) +
                dfs(cur - numbers[depth], depth + 1, numbers, target);
    }
}
