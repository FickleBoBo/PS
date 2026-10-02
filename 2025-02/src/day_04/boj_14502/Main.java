package day_04.BOJ_14502;

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

    private static final int BLANK = 0;
    private static final int WALL = 1;

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        List<Node> blankList = new ArrayList<>();
        List<Node> virusList = new ArrayList<>();
        int wallCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == BLANK) blankList.add(new Node(i, j));
                else if (map[i][j] == WALL) wallCnt++;
                else virusList.add(new Node(i, j));
            }
        }

        int max = 0;

        for (int i = 0; i < blankList.size() - 2; i++) {
            map[blankList.get(i).r][blankList.get(i).c] = WALL;

            for (int j = i + 1; j < blankList.size() - 1; j++) {
                map[blankList.get(j).r][blankList.get(j).c] = WALL;

                for (int k = j + 1; k < blankList.size(); k++) {
                    map[blankList.get(k).r][blankList.get(k).c] = WALL;

                    boolean[][] visited = new boolean[N][M];
                    int virusCnt = 0;
                    for (Node virus : virusList) {
                        if (visited[virus.r][virus.c]) continue;

                        virusCnt += bfs(virus, N, M, map, visited);
                    }

                    max = Math.max(max, N * M - wallCnt - 3 - virusCnt);

                    map[blankList.get(k).r][blankList.get(k).c] = BLANK;
                }
                map[blankList.get(j).r][blankList.get(j).c] = BLANK;
            }
            map[blankList.get(i).r][blankList.get(i).c] = BLANK;
        }

        System.out.println(max);
    }

    private static int bfs(Node start, int N, int M, int[][] map, boolean[][] visited) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);

        visited[start.r][start.c] = true;

        int cnt = 1;

        while (!q.isEmpty()) {
            Node node = q.remove();

            for (int dir = 0; dir < 4; dir++) {
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] != BLANK || visited[nr][nc]) continue;

                q.add(new Node(nr, nc));
                visited[nr][nc] = true;
                cnt++;
            }
        }

        return cnt;
    }

}
