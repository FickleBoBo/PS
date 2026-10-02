package day_23.BOJ_G4_14938;

import java.io.*;
import java.util.*;

public class Main_Floyd {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        // 각 지역의 아이템의 개수를 저장
        int[] W = new int[1+N];

        // 각 지역의 아이템 개수 초기화
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=N ; i++) W[i] = Integer.parseInt(st.nextToken());

        // 플로이드 워셜 알고리즘용 dp 테이블
        int[][] dp = new int[1+N][1+N];

        // 거리는 무한대로 초기화하고 자기 자신과의 거리는 0으로 초기화
        for(int i=1 ; i<=N ; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        // 연결된 지역에 대해 dp 테이블 갱신
        for(int i=0 ; i<R ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 양방향 통행
            dp[a][b] = dp[b][a] = w;
        }

        // 플로이드 워셜 알고리즘
        for(int k=1 ; k<=N ; k++){
            for(int i=1 ; i<=N ; i++){
                for(int j=1 ; j<=N ; j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        // 얻을 수 있는 최대 아이템 개수
        int ans = 0;

        // 1번 지역부터 얻을 수 있는 아이템이 최대인 지역인지 확인
        for(int i=1 ; i<=N ; i++){

            // 해당 지역에서 얻을 수 있는 아이템의 수
            int cnt = 0;

            // 다른 지역과의 거리가 M 이하이면 아이템을 얻을 수 있다
            for(int j=1 ; j<=N ; j++){
                if(dp[i][j] <= M){
                    cnt += W[j];
                }
            }

            // 출력할 정답과 비교 갱신
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
    }
}
