package day_08.BOJ_6087;

import java.io.*;
import java.util.*;

public class Main {

    // 지도에서 위치와 방향, 해당 위치까지 가는데 사용한 거울 개수를 갖는 노드 클래스
    private static class Node implements Comparable<Node> {
        int r;
        int c;
        int dir;
        int cnt;

        public Node(int r, int c, int dir, int cnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    private static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        Queue<int[]> pos = new ArrayDeque<>();
        char[][] map = new char[H][W];
        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'C') pos.add(new int[]{i, j});
            }
        }

        int min = dijkstra(pos.remove(), pos.remove(), H, W, map);
        System.out.println(min);
    }

    private static int dijkstra(int[] start, int[] end, int H, int W, char[][] map) {
        // 시작 위치에서 모든 방향으로 레이저 출발
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start[0], start[1], 0, 0));
        pq.add(new Node(start[0], start[1], 1, 0));
        pq.add(new Node(start[0], start[1], 2, 0));
        pq.add(new Node(start[0], start[1], 3, 0));

        // 위치와 해당 위치로 온 레이저 방향에 대한 방문 체크 배열
        boolean[][][] visited = new boolean[H][W][4];

        // 다익스트라 알고리즘의 거리 배열
        int[][][] cntMap = new int[H][W][4];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(cntMap[i][j], INF);
            }
        }
        cntMap[start[0]][start[1]][0] = 0;
        cntMap[start[0]][start[1]][1] = 0;
        cntMap[start[0]][start[1]][2] = 0;
        cntMap[start[0]][start[1]][3] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.remove();

            // 도착점이면 레이저 이동 종료
            if (node.r == end[0] && node.c == end[1]) continue;

            if (visited[node.r][node.c][node.dir]) continue;
            visited[node.r][node.c][node.dir] = true;

            for (int dir = 0; dir < 4; dir++) {
                int nr = node.r + dr[dir];
                int nc = node.c + dc[dir];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if (map[nr][nc] == '*' || visited[nr][nc][dir]) continue;

                // 현재 레이저 방향과 이동할 방향이 같은 방향인 경우
                if (node.dir == dir) {
                    if (cntMap[nr][nc][dir] > cntMap[node.r][node.c][node.dir]) {
                        cntMap[nr][nc][dir] = cntMap[node.r][node.c][node.dir];
                        pq.add(new Node(nr, nc, dir, cntMap[nr][nc][dir]));
                    }
                }
                // 현재 레이저 방향과 이동할 레이저 방향이 직각인 경우
                else if ((node.dir + 1 + 4) % 4 == dir || (node.dir - 1 + 4) % 4 == dir) {
                    if (cntMap[nr][nc][dir] > cntMap[node.r][node.c][node.dir] + 1) {
                        cntMap[nr][nc][dir] = cntMap[node.r][node.c][node.dir] + 1;
                        pq.add(new Node(nr, nc, dir, cntMap[nr][nc][dir]));
                    }
                }
            }
        }

        // 도착점에 온 레이저 방향에 대해 최솟값 반환
        return Math.min(Math.min(cntMap[end[0]][end[1]][0], cntMap[end[0]][end[1]][1]), Math.min(cntMap[end[0]][end[1]][2], cntMap[end[0]][end[1]][3]));
    }

}
