package day_21.BOJ_17071;

import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 500_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int time = bfs(N, K);
        System.out.println(time);
    }

    private static int bfs(int N, int K) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        // 홀수 시간에 대한 방문 체크
        int[] visitedOdd = new int[1 + MAX];
        Arrays.fill(visitedOdd, Integer.MAX_VALUE);

        // 짝수 시간에 대한 방문 체크
        int[] visitedEven = new int[1 + MAX];
        Arrays.fill(visitedEven, Integer.MAX_VALUE);
        visitedEven[N] = 0;

        int time = 0;

        while (!q.isEmpty()) {
            // 찾는 위치가 500,000을 넘어가면 종료
            if (K > MAX) return -1;

            // 홀수 시간에 홀수 시간 방문 체크를 한 경우 또는 짝수 시간에 짝수 시간 방문 체크를 한 경우 가능한 케이스
            if (visitedOdd[K] != Integer.MAX_VALUE && time % 2 == 1) return time;
            if (visitedEven[K] != Integer.MAX_VALUE && time % 2 == 0) return time;

            int len = q.size();

            for (int i = 0; i < len; i++) {
                int node = q.remove();
                if (node == K) return time;

                // 짝수 시간의 이동으로 홀수 시간 방문체크 배열 적용
                if (time % 2 == 0) {
                    // X-1로 이동하려는 경우로 0보다 작은 위치로 이동 X
                    if (node - 1 >= 0 && visitedOdd[node - 1] >= time) {
                        q.add(node - 1);
                        visitedOdd[node - 1] = time;
                    }

                    // X+1로 이동하려는 경우로 500,000보다 큰 위치로 이동 X
                    if (node + 1 <= MAX && visitedOdd[node + 1] >= time) {
                        q.add(node + 1);
                        visitedOdd[node + 1] = time;
                    }

                    // 2*X로 이동하려는 경우로 500,000보다 큰 위치로 이동 X
                    if (node * 2 <= MAX && visitedOdd[node * 2] >= time) {
                        q.add(node * 2);
                        visitedOdd[node * 2] = time;
                    }
                }
                // 홀수 시간의 이동으로 짝수 시간 방문체크 배열 적용
                else {
                    // X-1로 이동하려는 경우로 0보다 작은 위치로 이동 X
                    if (node - 1 >= 0 && visitedEven[node - 1] >= time) {
                        q.add(node - 1);
                        visitedEven[node - 1] = time;
                    }

                    // X+1로 이동하려는 경우로 500,000보다 큰 위치로 이동 X
                    if (node + 1 <= MAX && visitedEven[node + 1] >= time) {
                        q.add(node + 1);
                        visitedEven[node + 1] = time;
                    }

                    // 2*X로 이동하려는 경우로 500,000보다 큰 위치로 이동 X
                    if (node * 2 <= MAX && visitedEven[node * 2] >= time) {
                        q.add(node * 2);
                        visitedEven[node * 2] = time;
                    }
                }
            }

            time++;

            // 동생 위치 이동
            K += time;
        }

        return -1;
    }

}
