package day_06.PRMS_118669;

import java.util.*;

class Solution {

    private static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    private static final List<List<Node>> adj = new ArrayList<>();
    private static final Set<Integer> gateSet = new HashSet<>();
    private static final Set<Integer> summitSet = new HashSet<>();

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // 양방향 연결
        for (int[] path : paths) {
            adj.get(path[0]).add(new Node(path[1], path[2]));
            adj.get(path[1]).add(new Node(path[0], path[2]));
        }

        for (int gate : gates) {
            gateSet.add(gate);
        }

        for (int summit : summits) {
            summitSet.add(summit);
        }

        // 정렬 안되어 있음
        Arrays.sort(summits);

        int[] ans = binarySearch(n, summits);
        return ans;
    }

    // 매개변수 이분탐색
    private static int[] binarySearch(int n, int[] summits) {
        int left = 1;
        int right = 10_000_000;

        int num = -1;
        int intensity = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean flag = false;

            // 번호가 낮은 산봉우리부터 출입구를 탐색하고 찾으면 해당 intensity에 대한 탐색 종료
            for (int summit : summits) {
                boolean result = bfs(summit, mid, n);

                if (result) {
                    num = summit;
                    intensity = mid;
                    flag = true;
                    break;
                }
            }

            // 포인터 이동
            if (!flag) left = mid + 1;
            else right = mid - 1;
        }

        return new int[]{num, intensity};
    }

    // 산봉우리에서 다른 산봉우리를 제외한 지점을 찾아다니며 출입구를 찾으면 true 반환
    private static boolean bfs(int start, int maxLen, int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        boolean[] visited = new boolean[1 + n];
        visited[start] = true;

        while (!q.isEmpty()) {
            int node = q.remove();
            if (gateSet.contains(node)) return true;

            for (Node next : adj.get(node)) {
                if (visited[next.v]) continue;
                if (next.w > maxLen) continue;
                if (summitSet.contains(next.v)) continue;

                q.add(next.v);
                visited[next.v] = true;
            }
        }

        return false;
    }

}
