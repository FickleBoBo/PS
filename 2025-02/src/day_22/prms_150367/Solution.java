package day_22.PRMS_150367;

class Solution {

    public int[] solution(long[] numbers) {
        int N = numbers.length;
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            ans[i] = solve(numbers[i]);
        }

        return ans;
    }

    private static int solve(long number) {
        String input = Long.toBinaryString(number);

        // 주어진 이진트리로 포화 이진트리를 만들었을 때 크기 계산
        int treeSize = 2;
        while (treeSize <= input.length()) {
            treeSize <<= 1;
        }
        treeSize--;

        // 주어진 이진트리와 포화 이진트리의 크기 차이만큼 앞에 0 붙임
        StringBuilder dummy = new StringBuilder();
        for (int i = input.length(); i < treeSize; i++) {
            dummy.append("0");
        }

        char[] tree = (dummy.append(input).toString()).toCharArray();

        int cnt = dfs(tree, tree.length / 2, tree.length / 2);
        return cnt == Long.bitCount(number) ? 1 : 0;
    }

    private static int dfs(char[] tree, int subTreeSize, int node) {
        if (tree[node] == '0') return 0;
        if (subTreeSize == 0) return tree[node] == '1' ? 1 : 0;

        int cnt = 1;

        cnt += dfs(tree, subTreeSize / 2, node - (subTreeSize + 1) / 2);
        cnt += dfs(tree, subTreeSize / 2, node + (subTreeSize + 1) / 2);

        return cnt;
    }

}
