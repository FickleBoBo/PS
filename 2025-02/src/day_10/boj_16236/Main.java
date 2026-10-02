package day_10.BOJ_16236;

import java.io.*;
import java.util.*;

public class Main {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    // 아기 상어의 위치와 크기
    private static int r = -1;
    private static int c = -1;
    private static int size = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 아기 상어 정보 초기화 후 맵에서 삭제
                if (map[i][j] == 9) {
                    r = i;
                    c = j;
                    map[i][j] = 0;
                }
            }
        }

        int ans = 0;  // 시뮬레이션 시간
        int cnt = 0;  // 먹은 물고기 수
        while (true) {
            int time = bfs(N, map);
            if (time == -1) break;  // 더이상 물고기를 먹을 수 없는 경우로 엄마 상어에게 도움 요청하면 종료

            ans += time;
            cnt++;

            // 아기 상어가 자신의 크기와 같은 수의 물고기를 먹으면 크기 1 증가
            if (cnt == size) {
                size++;
                cnt = 0;
            }
        }

        System.out.println(ans);
    }

    private static int bfs(int N, int[][] map) {
        // 아기 상어는 가장 위에 있는, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 우선으로 먹는다
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        pq.add(new int[]{r, c});

        boolean[][] visited = new boolean[N][N];
        visited[r][c] = true;

        int dist = 0;

        while (!pq.isEmpty()) {
            // 새로운 위치들은 임시 저장
            PriorityQueue<int[]> stored = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return Integer.compare(o1[0], o2[0]);
            });

            int len = pq.size();

            for (int i = 0; i < len; i++) {
                int[] node = pq.remove();

                // 먹을 수 있는 물고기가 있는 칸이면 먹고 아기 상어의 위치를 변경하고 종료
                if (0 < map[node[0]][node[1]] && map[node[0]][node[1]] < size) {
                    r = node[0];
                    c = node[1];
                    map[r][c] = 0;
                    return dist;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if (map[nr][nc] > size || visited[nr][nc]) continue;

                    stored.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            // 임시 저장한 위치를 실제 위치로 설정
            pq = stored;

            dist++;
        }

        return -1;
    }

}
