package day_15.BOJ_G5_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 익은 토마토를 기준으로 사방탐색
    static int[] dr = {-1, 0, 1, 0};    // 상 우 하 좌
    static int[] dc = {0, 1, 0, -1};    // 상 우 하 좌

    public static void main(String[] args) throws IOException {



        /* step 1 - 입력 받기
        *
        *  37%에서 시간 초과 나서 입력 받기를 한번 바꿔 보려고 연습함(문제 접근이 틀려서 시간초과;;)
        *  버퍼드리더 + 스트링빌더 + 스트링토크나이저 콤보
        *  버퍼드리더로 쭉 읽은거를 스트링빌더로 합쳐서 한 줄로 만들고 토크나이저로 부시기
        *
        *  그냥 야매로 어떻게 됐는데 입력 패턴에 대한 공부 필요할 듯
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine() + " ");
        while (br.ready()) {    // 이거 메서드 쓰니까 얼추 됨
            sb.append(br.readLine() + " ");
        }
        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];                      // map : 토마토 농장
        boolean[][] visited = new boolean[N][M];          // visited : 방문 체크

        Queue<int[]> tomatoQueue = new LinkedList<>();    // tomatoQueue : 익은 토마토의 좌표를 먼저 담고, 이후 익을 토마토의 좌표를 담음(뒤에서 날짜를 늘려줄거라 익을 토마토가 익은 토마토가 됨)
        int emptyCnt = 0;                                 // emptyCnt : 빈칸(== -1)

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {                       // 익은 토마토 발견하면
                    visited[i][j] = true;                  // 방문 체크
                    tomatoQueue.offer(new int[]{i, j});    // 토마토 큐에 담아줌
                }
                else if(map[i][j] == -1){                  // 빈칸이면
                    visited[i][j] = true;                  // 방문 체크(어차피 안돌거라)
                    emptyCnt++;                            // 빈칸 개수 하나 늘려줌
                }
            }
        }
        int tomatoCnt = tomatoQueue.size();                // tomatoCnt : 익은 토마토의 개수로 토마토 큐의 크기와 같겠지?
        int day = 0;                                       // day : 정답(== 지난 날짜)



        /* step 2 - 정답 구하기
        *
        * */
        if(tomatoCnt == M * N - emptyCnt){                 // 빈칸 제외 모든 토마토가 익었으면 바로 끝내기
            System.out.println(day);
        }
        else{
            while(true){    // 새롭게 익을 토마토가 없으면 종료
                int n = tomatoQueue.size();    // 현재 담긴 익은 토마토를 다 쓸 때까지만 반복(새로 담을거라 횟수를 미리 정해줌)
                while(n > 0){
                    int[] item = tomatoQueue.poll();    // 익은 토마토 하나 꺼내서
                    for(int dir=0 ; dir<4 ; dir++){     // 사방 탐색하며 주변 토마토 방문체크하고 담기(BFS랑 거의 비슷한 듯)
                        int nr = item[0] + dr[dir];
                        int nc = item[1] + dc[dir];
                        if((nr>=0) && (nc>=0) && (nr<N) && (nc<M) && (!visited[nr][nc]) && (map[nr][nc] == 0)){
                            visited[nr][nc] = true;
                            tomatoQueue.offer(new int[]{nr, nc});
                        }
                    }
                    n--;    // 토마토 하나 꺼낼때마다 -1
                }

                tomatoCnt += tomatoQueue.size();    // 새롭게 담은 토마토 수만큼 토마토 갯수 늘려줌
                if(tomatoQueue.isEmpty()) break;    // 새롭게 담은 토마토가 없을 경우 종료
                day++;                              // 종료 안했으면 다시 반복이므로 날짜를 하루 늘려줌
            }

            if(tomatoCnt == M * N - emptyCnt){      // 토마토가 전부 익었으면 날짜 출력
                System.out.println(day);
            }
            else{
                System.out.println(-1);             // 덜익은 토마토가 있으면 -1 출력
            }
        }

        br.close();

    }
}
