package day_22.BOJ_G3_2342;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 높이는 지시 사항 순서, 행은 왼발, 열은 오른발을 저장하는 dp 테이블
        // 지시 사항의 크기만큼 높이가 되는데 뒤에 0으로 지시 사항이 끝나는거랑 dp에 필요한 패딩이 딱 맞음
        int[][][] dp = new int[st.countTokens()][5][5];

        // dp 테이블 초기화로 첫 스텝은 무조건 힘2짜리 왼발 or 오른발 밖에 없음
        int n = Integer.parseInt(st.nextToken());
        dp[1][0][n] = 2;    // 1번 명령, 왼발 0, 오른발 n에 위치한다는 뜻
        dp[1][n][0] = 2;    // 1번 명령, 왼발 n, 오른발 0에 위치한다는 뜻

        for(int h=2 ; h<dp.length ; h++){
            n = Integer.parseInt(st.nextToken());

            for(int i=0 ; i<5 ; i++){
                for(int j=0 ; j<5 ; j++){
                    if(dp[h-1][i][j] > 0){    // 0은 해당하는 경우가 없으므로 패스
                        int left;    // 왼발 이동시 들어갈 힘
                        int right;    // 오른발 이동시 들어갈 힘

                        if(j == 0) left = 2;
                        else if(j == n) left = 1;
                        else if((j + 2) % 4 == n % 4) left = 4;
                        else left = 3;

                        if(i == 0) right = 2;
                        else if(i == n) right = 1;
                        else if((i + 2) % 4 == n % 4) right = 4;
                        else right = 3;

                        // 왼발 이동에 대한 dp 테이블 갱신인데 그냥 해당 위치에 올 수 있는 최솟값 넣는거
                        // 0이 아닌 최솟값을 넣어야 해서 이렇게 했는데 dp 테이블 전체를 INF로 초기화하는거 보다 나아보였음
                        if(dp[h][i][n] == 0) dp[h][i][n] = dp[h-1][i][j] + left;
                        else dp[h][i][n] = Math.min(dp[h][i][n], dp[h-1][i][j] + left);

                        // 오른발 이동에 대한 dp 테이블 갱신인데 그냥 해당 위치에 올 수 있는 최솟값 넣는거
                        // 0이 아닌 최솟값을 넣어야 해서 이렇게 했는데 dp 테이블 전체를 INF로 초기화하는거 보다 나아보였음
                        if(dp[h][n][j] == 0) dp[h][n][j] = dp[h-1][i][j] + right;
                        else dp[h][n][j] = Math.min(dp[h][n][j], dp[h-1][i][j] + right);
                    }
                }
            }
        }

        // 마지막 명령까지 다했으면 두 발의 위치에 대한 최솟값을 찾으면 됨(여기도 0이 아닌 경우로)
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<5 ; i++){
            for(int j=0 ; j<5 ; j++){
                if(dp[dp.length-1][i][j] > 0){
                    min = Math.min(min, dp[dp.length-1][i][j]);
                }
            }
        }

        System.out.println(min);
    }
}
