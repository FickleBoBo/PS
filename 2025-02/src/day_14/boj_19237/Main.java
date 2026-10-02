package day_14.BOJ_19237;

import java.io.*;
import java.util.*;

public class Main {

    private static class Shark implements Comparable<Shark> {
        int num;  // 상어의 번호
        int r;  // 상어의 행 좌표
        int c;  // 상어의 열 좌표
        int d;  // 상어의 방향(위:0, 아래:1, 왼쪽:2, 오른쪽: 3)
        int[][] dir = new int[4][4];  // 현재 방향에 따른 다음 방향 배열
        int[][] dr = new int[4][4];  // 현재 방향에 따른 다음 행 좌표 방향 배열
        int[][] dc = new int[4][4];  // 현재 방향에 따른 다음 열 좌표 방향 배열

        public Shark(int num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }

        // 우선순위 큐에서 번호가 작은 상어를 남기기 위해 상어의 번호에 대한 내림차순으로 정렬
        @Override
        public int compareTo(Shark o) {
            return Integer.compare(o.num, this.num);
        }
    }

    // 방향 배열 (위:0, 아래:1, 왼쪽:2, 오른쪽: 3)
    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 상어의 정보에 대한 입력은 오름차순으로 주어지므로 임시로 리스트에 담아 처리
        List<Shark> input = new ArrayList<>();

        // 맵의 각 격자에 상어를 담는 우선순위 큐 2차원 배열
        PriorityQueue<Shark>[][] sharkMap = new PriorityQueue[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sharkMap[i][j] = new PriorityQueue<>();
            }
        }

        // 맵의 각 격자에 냄새 번호를 저장하는 맵
        int[][] numMap = new int[N][N];

        // 맵의 각 격자에 냄새 지속지간을 저장하는 맵
        int[][] smellMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num != 0) {
                    Shark shark = new Shark(num, i, j);

                    input.add(shark);
                    numMap[i][j] = num;
                    smellMap[i][j] += K;
                }
            }
        }
        // 기본 정렬이 내림차순이라 리스트에서는 오름차순으로 정렬
        input.sort(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (Shark shark : input) {
            shark.d = Integer.parseInt(st.nextToken()) - 1;
        }

        for (Shark shark : input) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                int[] dir = new int[4];
                int[] dr = new int[4];
                int[] dc = new int[4];

                for (int k = 0; k < 4; k++) {
                    int num = Integer.parseInt(st.nextToken()) - 1;
                    dir[k] = num;
                    dr[k] = DR[num];
                    dc[k] = DC[num];
                }

                shark.dir[j] = dir;
                shark.dr[j] = dr;
                shark.dc[j] = dc;
            }
        }

        PriorityQueue<Shark> sharks = new PriorityQueue<>(input);

        for (int sec = 1; sec <= 1000; sec++) {
            move(N, K, sharks, sharkMap, numMap, smellMap);

            // 남은 상어가 1마리보다 많으면 시뮬레이션 지속
            if (sharks.size() != 1) continue;

            System.out.println(sec);
            return;
        }

        System.out.println(-1);
    }

    private static void move(int N, int K, PriorityQueue<Shark> sharks, PriorityQueue<Shark>[][] sharkMap, int[][] numMap, int[][] smellMap) {
        // 상어 우선순위 큐에서 한마리씩 꺼내서 이동시킨다
        while (!sharks.isEmpty()) {
            Shark shark = sharks.remove();
            boolean flag = false;

            for (int dir = 0; dir < 4; dir++) {
                int nr = shark.r + shark.dr[shark.d][dir];
                int nc = shark.c + shark.dc[shark.d][dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (numMap[nr][nc] != 0) continue;

                shark.r = nr;
                shark.c = nc;
                shark.d = shark.dir[shark.d][dir];

                sharkMap[nr][nc].add(shark);
                flag = true;
                break;
            }

            // 주변에 빈 칸이 없으면 자신의 냄새가 있는 칸으로 이동
            if (!flag) {
                for (int dir = 0; dir < 4; dir++) {
                    int nr = shark.r + shark.dr[shark.d][dir];
                    int nc = shark.c + shark.dc[shark.d][dir];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                    if (numMap[nr][nc] == shark.num) {
                        shark.r = nr;
                        shark.c = nc;
                        shark.d = shark.dir[shark.d][dir];

                        sharkMap[nr][nc].add(shark);
                        break;
                    }
                }
            }
        }

        // 이동 시킨 상어에 대해 한 칸에 여러마리가 있으면 번호가 가장 작은 상어만 남기고 기존 냄새를 갱신하고 새로운 냄새를 뿌린다
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smellMap[i][j] > 0) smellMap[i][j]--;
                if (smellMap[i][j] == 0) numMap[i][j] = 0;

                if (sharkMap[i][j].isEmpty()) continue;

                while (sharkMap[i][j].size() > 1) {
                    sharkMap[i][j].remove();
                }

                Shark shark = sharkMap[i][j].remove();

                numMap[i][j] = shark.num;
                smellMap[i][j] = K;
                sharks.add(shark);
            }
        }
    }

}
