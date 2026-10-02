package day_02.BOJ_G4_11054;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N];    // 앞에서부터 증가하는 부분 수열의 길이를 저장
        int[] dp2 = new int[N];    // 뒤에서부터 증가하는 부분 수열의 길이를 저장

        Arrays.fill(dp1, 1);    // 자기 자신은 길이 1짜리 부분수열
        Arrays.fill(dp2, 1);    // 자기 자신은 길이 1짜리 부분수열

        // 앞에서부터 증가하는 부분 수열의 길이 구하기
        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<i ; j++){
                if(arr[i] > arr[j]){
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        // 뒤에서부터 증가하는 부분 수열의 길이 구하기
        // 앞에서부터 감소하는 부분 수열의 길이랑 다름
        for(int i=N-1 ; i>=0 ; i--){
            for(int j=N-1 ; j>i ; j--){
                if(arr[i] > arr[j]){
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0 ; i<N ; i++){
            max = Math.max(max, dp1[i] + dp2[i] - 1);    // 둘의 합에서 1을 빼야됨(중복)
        }

        System.out.println(max);
    }
}
