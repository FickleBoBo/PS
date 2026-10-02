package day_24.BOJ_23290;

import java.io.*;
import java.util.*;

public class Main {

    private static class Fish {
        int r;
        int c;
        int d;

        public Fish(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    // ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 델타 배열
    private static final int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

    // 상어가 최대로 제외할 수 있는 물고기 수
    private static int maxCnt;

    // 상어가 최대로 제외할 수 있는 경우 방향 배열
    private static int[] maxCntDir;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // 물고기를 보관하는 Queue
        Queue<Fish> q = new ArrayDeque<>();
        // 각 위치의 물고기 수를 저장
        int[][] cntMap = new int[4][4];
        // 각 위치의 냄새 정보 저장
        int[][] smellMap = new int[4][4];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;

            q.add(new Fish(r, c, d));
            cntMap[r][c]++;
        }

        st = new StringTokenizer(br.readLine());
        int sharkR = Integer.parseInt(st.nextToken()) - 1;
        int sharkC = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < S; i++) {
            // 작업 1
            Queue<Fish> stored = new ArrayDeque<>(q);

            // 작업 2
            moveFish(sharkR, sharkC, q, cntMap, smellMap);

            // 작업 3
            maxCnt = 0;
            maxCntDir = new int[3];

            // 최대로 제외할 수 있는 방향 탐색
            moveShark(sharkR, sharkC, cntMap, new boolean[4][4], 0, new int[3], 0);

            // 방향 정보로 실제 물고기를 제외시킴
            removeFish(sharkR, sharkC, q, cntMap, smellMap);

            // 상어의 위치 갱신
            sharkR += dr[maxCntDir[0]] + dr[maxCntDir[1]] + dr[maxCntDir[2]];
            sharkC += dc[maxCntDir[0]] + dc[maxCntDir[1]] + dc[maxCntDir[2]];

            // 작업 4
            removeSmellMap(smellMap);

            // 작업 5
            replicateFish(stored, q, cntMap);
        }

        System.out.println(q.size());
    }

    private static void moveFish(int sharkR, int sharkC, Queue<Fish> q, int[][] cntMap, int[][] smellMap) {
        int len = q.size();

        out:
        for (int i = 0; i < len; i++) {
            Fish fish = q.remove();

            for (int dir = 0; dir < 8; dir++) {
                int nd = (fish.d - dir + 8) % 8;
                int nr = fish.r + dr[nd];
                int nc = fish.c + dc[nd];

                if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;
                if (nr == sharkR && nc == sharkC) continue;
                if (smellMap[nr][nc] > 0) continue;

                q.add(new Fish(nr, nc, nd));
                cntMap[fish.r][fish.c]--;
                cntMap[nr][nc]++;

                continue out;
            }

            // 물고기가 갈 수 있는 곳이 없으면 이동하지 않는다
            q.add(fish);
        }
    }

    private static void moveShark(int sharkR, int sharkC, int[][] fishMap, boolean[][] visited, int cnt, int[] dirArr, int depth) {
        // 상어는 최대 3칸 이동 가능
        if (depth == 3) {
            if (cnt >= maxCnt) {
                maxCnt = cnt;
                maxCntDir = dirArr.clone();
            }
            return;
        }

        // 방문 체크
        visited[sharkR][sharkC] = true;

        for (int dir = 0; dir < 8; dir += 2) {
            // 사전순을 위한 인덱싱 처리
            int nd = (dir + 4) % 8;
            int nr = sharkR + dr[nd];
            int nc = sharkC + dc[nd];

            if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4) continue;

            dirArr[depth] = nd;

            // 방문한 곳의 물고기는 중복 제외하지 않게 처리
            if (visited[nr][nc]) moveShark(nr, nc, fishMap, visited, cnt, dirArr, depth + 1);
            else moveShark(nr, nc, fishMap, visited, cnt + fishMap[nr][nc], dirArr, depth + 1);
        }

        // 방문 체크 해제
        visited[sharkR][sharkC] = false;
    }

    private static void removeFish(int sharkR, int sharkC, Queue<Fish> q, int[][] cntMap, int[][] smellMap) {
        int r1 = sharkR + dr[maxCntDir[0]];
        int c1 = sharkC + dc[maxCntDir[0]];
        int r2 = r1 + dr[maxCntDir[1]];
        int c2 = c1 + dc[maxCntDir[1]];
        int r3 = r2 + dr[maxCntDir[2]];
        int c3 = c2 + dc[maxCntDir[2]];

        if (cntMap[r1][c1] != 0) {
            smellMap[r1][c1] = 3;
            cntMap[r1][c1] = 0;
        }
        if (cntMap[r2][c2] != 0) {
            smellMap[r2][c2] = 3;
            cntMap[r2][c2] = 0;
        }
        if (cntMap[r3][c3] != 0) {
            smellMap[r3][c3] = 3;
            cntMap[r3][c3] = 0;
        }

        int len = q.size();
        for (int i = 0; i < len; i++) {
            Fish fish = q.remove();

            if (!(fish.r == r1 && fish.c == c1) && !(fish.r == r2 && fish.c == c2) && !(fish.r == r3 && fish.c == c3))
                q.add(fish);
        }
    }

    private static void replicateFish(Queue<Fish> stored, Queue<Fish> q, int[][] cntMap) {
        q.addAll(stored);

        while (!stored.isEmpty()) {
            Fish fish = stored.remove();
            cntMap[fish.r][fish.c]++;
        }
    }

    private static void removeSmellMap(int[][] smellMap) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (smellMap[i][j] > 0) smellMap[i][j]--;
            }
        }
    }

}
