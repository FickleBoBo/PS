package day_14.BOJ_S1_2178;

import java.io.*;
import java.util.*;

public class Main {

    // 사방탐색 델타배열
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static int M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0 ; i<N ; i++){
            map[i] = br.readLine().toCharArray();
        }

        int ans = BFS();
        System.out.println(ans);
    }

    // 최단거리 계산은 BFS로 구할 수 있다
    private static int BFS() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        map[0][0] = '0';    // 원본 맵을 수정해서 방문체크

        int ans = 1;

        while (!q.isEmpty()) {
            int len = q.size();

            // BFS로 최단거리를 구하는 방법
            for (int i=0 ; i<len ; i++) {
                int[] node = q.poll();

                for (int dir=0 ; dir<4 ; dir++) {
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];
                    if (nr>=0 && nr<N && nc>=0 && nc<M && (map[nr][nc]=='1')) {

                        // 새로운 좌표가 도착지면 종료하는데 최단거리를 갱신하기 전이라서 +1을 해서 리턴
                        // 출발위치와 도착위치가 다른 것이 보장돼서 가능한 조건
                        if((nr==N-1) && (nc==M-1)){
                            return ans + 1;
                        }

                        q.offer(new int[]{nr, nc});
                        map[nr][nc] = '0';
                    }
                }

            }

            // Queue의 길이만큼 돌면 (1, 1)부터의 거리가 1 증가
            ans++;
        }

        // 도착지를 못 찾으면 -1을 리턴해서 문제가 있음 표현(실제로 출력될 일은 없음)
        return -1;
    }

}
