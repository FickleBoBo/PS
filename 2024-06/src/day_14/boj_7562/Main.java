package day_14.BOJ_S1_7562;

import java.io.*;
import java.util.*;

public class Main {

    // 나이트 이동 델타배열
    static int[] dr = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dc = {-1, 1, 2, 2, 1, -1, -2, -2};

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            N = Integer.parseInt(br.readLine());

            // 현재 위치
            st = new StringTokenizer(br.readLine());
            int[] curr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            // 목표 위치
            st = new StringTokenizer(br.readLine());
            int[] target = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            int ans = BFS(curr, target);
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    // 최단거리 계산은 BFS로 구할 수 있다
    private static int BFS(int[] curr, int[] target) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(curr);

        boolean[][] visited = new boolean[N][N];
        visited[curr[0]][curr[1]] = true;

        int ans = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            // BFS로 최단거리를 구하는 방법
            for (int i=0 ; i<len ; i++) {
                int[] node = q.poll();

                // target을 찾으면 종료
                if((node[0]==target[0]) && (node[1]==target[1])){
                    return ans;
                }

                for (int dir=0 ; dir<8 ; dir++) {
                    int nr = node[0] + dr[dir];
                    int nc = node[1] + dc[dir];
                    if (nr>=0 && nr<N && nc>=0 && nc<N && (!visited[nr][nc])){
                        q.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }

            }

            // Queue의 길이만큼 돌면 이동 횟수가 한번 증가
            ans++;
        }

        // 도착지를 못 찾으면 -1을 리턴해서 문제가 있음 표현(나이트의 이동에서 실제로 출력될 일은 없음)
        return -1;
    }

}
