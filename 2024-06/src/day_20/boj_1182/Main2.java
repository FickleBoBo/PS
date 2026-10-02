package day_20.BOJ_S2_1182;

import java.io.*;
import java.util.StringTokenizer;

public class Main_PowerSet {

    static int N;
    static int[] arr;

    static int S;
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

        powerSet(0, 0);

        // powerSet은 아무 원소도 뽑지 않아서 sum이 0인 경우가 있는데 S가 0일 경우
        // 해당 공집합도 하나로 카운트 되는데 크기가 양수인 부분수열에 대해서만 경우의 수를 구하므로 -1
        if(S == 0){
            cnt--;
        }
        System.out.println(cnt);
    }

    private static void powerSet(int idx, int sum){
        if(idx == N){
            if(sum == S){
                cnt++;
            }
            return;
        }

        // arr의 idx번 원소를 뽑는 경우
        powerSet(idx+1, sum+arr[idx]);

        // arr의 idx번 원소를 뽑지 않는 경우
        powerSet(idx+1, sum);
    }

}
