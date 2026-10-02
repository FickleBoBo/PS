package day_04.BOJ_17142;

import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static final int WALL = 1;
    private static final int INACTIVE_VIRUS = 2;

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static final List<Node> virusList = new ArrayList<>();
    private static Node[] sel;

    private static int N;
    private static int[][] map;

    private static int wallCnt = 0;
    private static int virusCnt = 0;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == WALL) wallCnt++;
                else if (map[i][j] == INACTIVE_VIRUS) {
                    virusList.add(new Node(i, j));
                    virusCnt++;
                }
            }
        }

        sel = new Node[M];

        combination(0, 0);

        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }

    private static void combination(int idx, int selIdx) {
        if (selIdx == sel.length) {
            boolean[][] visited = new boolean[N][N];
            int dist = bfs(sel, N, map, visited);

            if (dist == -1) return;

            min = Math.min(min, dist);
            return;
        }

        for (int i = idx; i < virusList.size(); i++) {
            sel[selIdx] = virusList.get(i);
            combination(i + 1, selIdx + 1);
        }
    }

    private static int bfs(Node[] start, int N, int[][] map, boolean[][] visited) {
        Queue<Node> q = new ArrayDeque<>(Arrays.asList(start));

        for (Node node : start) {
            visited[node.r][node.c] = true;
        }

        int cnt = virusCnt;
        int dist = 0;

        while (!q.isEmpty()) {
            if (cnt == N * N - wallCnt) return dist;

            int len = q.size();

            for (int i = 0; i < len; i++) {
                Node node = q.remove();

                for (int dir = 0; dir < 4; dir++) {
                    int nr = node.r + dr[dir];
                    int nc = node.c + dc[dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (map[nr][nc] == WALL || visited[nr][nc]) continue;

                    q.add(new Node(nr, nc));
                    visited[nr][nc] = true;
                    if (map[nr][nc] != INACTIVE_VIRUS) cnt++;
                }
            }

            dist++;
        }

        return -1;
    }

}
