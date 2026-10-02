package day_08.BOJ_18809;

import java.io.*;
import java.util.*;

public class Main {

    // 각 땅의 위치 및 색 class
    private static class Node {
        int r;
        int c;
        int state;

        public Node(int r, int c, int state) {
            this.r = r;
            this.c = c;
            this.state = state;
        }
    }

    private static final List<Node> list = new ArrayList<>();  // 배양액을 뿌릴 수 있는 땅
    private static boolean[] selected;                         // 초록색 배양액에 대한 방문 체크
    private static Node[] selG;                                // 조합에서 선택한 초록색 배양액 배열
    private static Node[] selR;                                // 조합에서 선택한 빨간색 배양액 배열

    private static int N;
    private static int M;
    private static int G;
    private static int R;

    private static int[][] map;
    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static final int WATER = 0;
    private static final int WHITE = 1;
    private static final int YELLOW = 2;
    private static final int GREEN = 3;
    private static final int RED = 4;
    private static final int FLOWER = 5;

    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == YELLOW) list.add(new Node(i, j, YELLOW));
            }
        }

        selected = new boolean[list.size()];
        selG = new Node[G];
        selR = new Node[R];

        combinationG(0, 0);

        System.out.println(ans);
    }

    // 황토색 칸 중 초록색 배양액을 뿌릴 곳을 구하는 조합 메서드
    // selected 배열에 초록색 배양액을 뿌린 것을 체크
    private static void combinationG(int idx, int selIdx) {
        if (selIdx == G) {
            combinationR(0, 0);
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            selG[selIdx] = list.get(i);
            selected[i] = true;
            combinationG(i + 1, selIdx + 1);
            selected[i] = false;
        }
    }

    // 초록색 배양액을 뿌리고 남은 황토색 칸 중 빨간색 배양액을 뿌릴 곳을 구하는 조합 메서드
    private static void combinationR(int idx, int selIdx) {
        if (selIdx == R) {
            bfs();
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            if (selected[i]) continue;

            selR[selIdx] = list.get(i);
            combinationR(i + 1, selIdx + 1);
        }
    }

    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        int[][] visited = new int[N][M];

        // 조합으로 땅을 선택만 한 상태라 색은 YELLOW 로 되있어서 배양액 색을 넣어줌
        for (Node node : selG) {
            q.offer(new Node(node.r, node.c, GREEN));
            visited[node.r][node.c] = GREEN;
        }
        for (Node node : selR) {
            q.offer(new Node(node.r, node.c, RED));
            visited[node.r][node.c] = RED;
        }

        // 배양액을 뿌린 시간을 저장
        int[][] timeMap = new int[N][M];

        int time = 1;
        int flower = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node node = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int nr = node.r + dr[dir];
                    int nc = node.c + dc[dir];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                    if (map[nr][nc] == WATER || visited[nr][nc] == FLOWER || visited[nr][nc] == node.state) continue;
                    if ((visited[nr][nc] == GREEN || visited[nr][nc] == RED) && (timeMap[nr][nc] < time)) continue;

                    // 큐에 넣은 이후 해당 땅이 꽃이 될 수 있음
                    if (visited[node.r][node.c] == FLOWER) continue;

                    if ((visited[nr][nc] == GREEN && node.state == RED && (timeMap[nr][nc] == time)) ||
                            (visited[nr][nc] == RED && node.state == GREEN && (timeMap[nr][nc] == time))) {
                        visited[nr][nc] = FLOWER;
                        flower++;
                        continue;
                    }

                    q.offer(new Node(nr, nc, node.state));
                    visited[nr][nc] = node.state;
                    timeMap[nr][nc] = time;
                }
            }

            time++;
        }

        ans = Math.max(ans, flower);
    }

}
