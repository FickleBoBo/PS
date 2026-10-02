package day_26.BOJ_G5_6593;

import java.io.*;
import java.util.*;

public class Main {

    // 육방 탐색 델타 배열
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};

    static int H;    // 높이
    static int R;    // 행
    static int C;    // 열
    static char[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(H==0) break;    // 종료 조건

            // step1 - 입력 받아서 초기화
            int[] start = {-1, -1, -1};
            map = new char[H][R][C];

            for(int h=0 ; h<H ; h++){
                for(int r=0 ; r<R ; r++){
                    String input = br.readLine();

                    for(int c=0 ; c<C ; c++){
                        map[h][r][c] = input.charAt(c);

                        if(map[h][r][c] == 'S'){
                            start = new int[]{h, r, c};
                        }
                    }
                }
                br.readLine();
            }

            // step2 - BFS로 출발지에서 목적지까지의 최단 거리 계산
            int ans = BFS(start);

            if(ans > 0){
                sb.append("Escaped in ").append(ans).append(" minute(s).\n");
            }
            else{
                sb.append("Trapped!\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int BFS(int[] start){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);

        boolean[][][] visited = new boolean[H][R][C];
        visited[start[0]][start[1]][start[2]] = true;

        int ans = 0;
        while(!q.isEmpty()){
            int len = q.size();

            for(int i=0 ; i<len ; i++){
                int[] node = q.poll();

                // 목적지를 찾으면 지금까지 구한 최단거리 반환
                if(map[node[0]][node[1]][node[2]] == 'E') return ans;

                for(int dir=0 ; dir<6 ; dir++){
                    int nh = node[0] + dh[dir];
                    int nr = node[1] + dr[dir];
                    int nc = node[2] + dc[dir];

                    if(nh>=0 && nh<H && nr>=0 && nr<R && nc>=0 && nc<C && !visited[nh][nr][nc]){
                        if(map[nh][nr][nc] != '#'){    // 벽이 아니면 일단 큐에 넣기
                            q.offer(new int[]{nh, nr, nc});
                            visited[nh][nr][nc] = true;
                        }
                    }
                }

            }

            ans++;
        }

        return 0;    // 큐가 빌 때까지 메서드가 리턴이 안됐으면 목적지를 못 찾은 거
    }

}
