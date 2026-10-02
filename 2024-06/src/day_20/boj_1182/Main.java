package day_20.BOJ_S2_1182;

import java.io.*;
import java.util.StringTokenizer;

public class Main_Combination {

    static int N;
    static int[] arr;

    static int S;
    static int sum = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1 ~ N 개의 원소를 뽑는 조합으로 부분집합 구하기
        for(int i=1 ; i<=N ; i++){
            combination(0, 0, i);
        }

        System.out.println(cnt);
    }

    private static void combination(int idx, int sidx, int maxLen){
        if(sidx == maxLen){
            if(sum == S){
                cnt++;
            }
            return;
        }

        for(int i=idx ; i<N ; i++){
            sum += arr[i];
            combination(i+1, sidx+1, maxLen);
            sum -= arr[i];
        }
    }

}
