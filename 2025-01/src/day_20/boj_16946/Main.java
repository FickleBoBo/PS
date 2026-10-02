package day_20.BOJ_16946;

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

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(input[j]);
            }
        }

        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    bfs(i, j, N, M, map, visited);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j] % 10);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static void bfs(int r, int c, int N, int M, int[][] map, boolean[][] visited) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(r, c));

        visited[r][c] = true;

        Queue<Node> edges = new ArrayDeque<>();

        int cnt = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;

                if (map[nr][nc] == 0) {
                    q.offer(new Node(nr, nc));
                    cnt++;
                } else {
                    edges.offer(new Node(nr, nc));
                }
                visited[nr][nc] = true;
            }
        }

        while (!edges.isEmpty()) {
            Node node = edges.poll();

            map[node.r][node.c] += cnt;
            visited[node.r][node.c] = false;
        }
    }

}
