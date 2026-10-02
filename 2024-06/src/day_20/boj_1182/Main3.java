package day_20.BOJ_S2_1182;

import java.io.*;
import java.util.StringTokenizer;

public class Main_Bitmask {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        // 비트마스킹으로 부분집합 구하기
        for(int i=1 ; i < (1<<N) ; i++){
            int sum = 0;

            for(int j=0 ; j<N ; j++){
                if((i & (1<<j)) != 0){
                    sum += arr[j];
                }
            }

            if(sum == S) cnt++;
        }

        System.out.println(cnt);
    }

}
