package day_13.BOJ_G4_11404;

import java.io.*;
import java.util.*;

public class Main {

    // 오버플로우 주의
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 인접 행렬겸 dp 테이블
        // 직행 버스가 없으면 일단 거리를 무한대로 설정하고 자기 자신과의 거리는 0으로 설정
        int[][] dp = new int[1+N][1+N];
        for(int i=1 ; i<=N ; i++){
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        // 인접 행렬을 초기화하는데 같은 노선이 여러 개 들어올 수 있음
        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            dp[A][B] = Math.min(dp[A][B], C);
        }

        // 플로이드 워셜 알고리즘
        // 1초 기준 n = 500이 최대
        // i -> j 를 k번 도시를 거치는게 더 가까우면 초기화하는걸 반복
        for(int k=1 ; k<=N ; k++){
            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=N ; j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        for(int i=1 ; i<=N ; i++){
            for(int j=1 ; j<=N ; j++){
                // i에서 j로 갈 수 없는 조건 체크해줘야함(테스트 케이스 97%)
                sb.append(dp[i][j] == INF ? 0 : dp[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
