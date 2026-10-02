package day_11.BOJ_19236;

import java.io.*;
import java.util.*;

public class Main {

    // ↑, ↖, ←, ↙, ↓, ↘, →, ↗ 순서의 방향 배열
    private static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};

    private static final int N = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] map = new int[4][4];  // 물고기의 번호가 표시된 맵
        int[][] dirMap = new int[4][4];  // 물고기의 방향이 표시된 맵
        Map<Integer, int[]> posMap = new HashMap<>();  // 물고기의 위치를 저장한 Map
        Set<Integer> deadFish = new HashSet<>();  // 잡아먹힌 물고기를 담은 Set

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;

                map[i][j] = n;
                dirMap[i][j] = d;
                posMap.put(n, new int[]{i, j});
            }
        }

        int ans = move(0, 0, map, dirMap, posMap, deadFish);
        System.out.println(ans);
    }

    private static int move(int sharkRow, int sharkCol, int[][] map, int[][] dirMap, Map<Integer, int[]> posMap, Set<Integer> deadFish) {
        // 상어가 해당 위치의 물고기를 잡아먹고 맵 갱신
        int num = map[sharkRow][sharkCol];
        int sharkDir = dirMap[sharkRow][sharkCol];

        map[sharkRow][sharkCol] = -1;
        dirMap[sharkRow][sharkCol] = -1;

        deadFish.add(num);

        // 1번부터 16번까지 살아있는 물고기는 이동
        for (int i = 1; i <= N * N; i++) {
            if (deadFish.contains(i)) continue;

            int r = posMap.get(i)[0];
            int c = posMap.get(i)[1];
            int d = dirMap[r][c];

            for (int dir = 0; dir < 8; dir++) {
                int nd = (d + dir) % 8;
                int nr = r + dr[nd];
                int nc = c + dc[nd];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (map[nr][nc] == -1) continue;  // 상어가 있는 칸

                // 빈 칸이면 해당 칸으로 이동 후 맵 갱신
                if (map[nr][nc] == 0) {
                    map[nr][nc] = map[r][c];
                    map[r][c] = 0;

                    dirMap[nr][nc] = nd;
                    dirMap[r][c] = -1;

                    posMap.put(i, new int[]{nr, nc});
                }
                // 다른 물고기가 있는 칸이면 두 물고기의 위치를 바꾸고 맵 갱신
                else {
                    int changed = map[nr][nc];
                    map[nr][nc] = map[r][c];
                    map[r][c] = changed;

                    int changedDir = dirMap[nr][nc];
                    dirMap[nr][nc] = nd;
                    dirMap[r][c] = changedDir;

                    posMap.put(changed, new int[]{r, c});
                    posMap.put(i, new int[]{nr, nc});
                }

                break;
            }
        }

        // 상어가 있는 칸을 빈칸으로 바꾸고 상어 이동 준비
        map[sharkRow][sharkCol] = 0;

        int max = 0;

        // 상어는 최대 3칸까지만 이동 가능
        for (int i = 1; i < 4; i++) {
            int nr = sharkRow + dr[sharkDir] * i;
            int nc = sharkCol + dc[sharkDir] * i;

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if (map[nr][nc] <= 0) continue;

            max = Math.max(max, move(nr, nc, clone(map), clone(dirMap), clone(posMap), clone(deadFish)));
        }

        return num + max;
    }

    // 2차원 배열 깊은 복사
    private static int[][] clone(int[][] map) {
        int[][] copyMap = map.clone();
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }
        return copyMap;
    }

    // Map 깊은 복사
    private static Map<Integer, int[]> clone(Map<Integer, int[]> map) {
        Map<Integer, int[]> copyMap = new HashMap<>();
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            copyMap.put(entry.getKey(), entry.getValue().clone());
        }
        return copyMap;
    }

    // Set 깊은 복사
    private static Set<Integer> clone(Set<Integer> set) {
        return new HashSet<>(set);
    }

}
