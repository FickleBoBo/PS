package day_20.BOJ_B2_13300;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 카운팅 맵
        int[][] cntMap = new int[2][1+6];
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            cntMap[S][Y]++;
        }

        int ans = 0;

        for(int i=0 ; i<=1 ; i++){
            for(int j=1 ; j<=6 ; j++){
                ans += cntMap[i][j] / K;    // 몫만큼 방이 필요
                if(cntMap[i][j] % K != 0) ans++;    // 나머지 학생들도 방이 필요
            }
        }

        System.out.println(ans);
    }
}
