package day_02.BOJ_16920;

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
        int P = Integer.parseInt(st.nextToken());

        int[] S = new int[1 + P];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= P; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        // 플레이어의 성 정보를 담는 Queue 배열
        Queue<Node>[] input = new ArrayDeque[1 + P];
        for (int i = 1; i <= P; i++) {
            input[i] = new ArrayDeque<>();
        }

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                if (map[i][j] != '.' && map[i][j] != '#') {
                    input[Character.getNumericValue(map[i][j])].add(new Node(i, j));
                }
            }
        }

        int[] cntArr = bfs(input, S, N, M, P, map);
        for (int i = 1; i <= P; i++) {
            sb.append(cntArr[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int[] bfs(Queue<Node>[] input, int[] S, int N, int M, int P, char[][] map) {
        while (true) {

            // 모든 Queue가 비어있으면 종료
            boolean flag = false;

            for (int n = 1; n <= P; n++) {
                Queue<Node> q = input[n];
                if (q.isEmpty()) continue;

                flag = true;
                int dist = 0;

                while (!q.isEmpty()) {
                    int len = q.size();

                    for (int i = 0; i < len; i++) {
                        Node node = q.remove();

                        for (int dir = 0; dir < 4; dir++) {
                            int nr = node.r + dr[dir];
                            int nc = node.c + dc[dir];

                            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                            if (map[nr][nc] != '.') continue;

                            q.add(new Node(nr, nc));
                            map[nr][nc] = (char) (n + '0');
                        }
                    }

                    dist++;
                    if (dist == S[n]) break;
                }
            }

            if (!flag) break;
        }

        int[] cntArr = new int[1 + P];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == '.' || map[i][j] == '#') continue;

                cntArr[Character.getNumericValue(map[i][j])]++;
            }
        }

        return cntArr;
    }

}
