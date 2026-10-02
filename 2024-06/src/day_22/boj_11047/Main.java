package day_22.BOJ_S4_11047;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for(int i=0 ; i<N ; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        // 동전의 가치가 다음 동전이 이전 동전의 배수로 주어져서 그리디 알고리즘으로 해결 가능
        for(int i=N-1 ; i>=0 ; i--){
            cnt += K / coins[i];
            K %= coins[i];
        }

        System.out.println(cnt);
    }
}
