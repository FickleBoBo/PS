package day_01.BOJ_G4_11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0 ; i<N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N];
        int[] dp2 = new int[N];

        for(int i=0 ; i<N ; i++){
            dp1[i] = 1;    // 자기 자신이 길이 1짜리 부분 수열이 되므로 최소 1
            dp2[N-1-i] = 1;    // 자기 자신이 길이 1짜리 부분 수열이 되므로 최소 1
            for(int j=0 ; j<i ; j++){
                // 자신보다 작은 원소의 LIS와 비교해서 갱신
                if(A[j] < A[i]){
                    dp1[i] = Math.max(dp1[j]+1, dp1[i]);
                }
                // 자신보다 작은 원소의 LIS와 비교해서 갱신
                if(A[N-1-j] < A[N-1-i]){
                    dp2[N-1-i] = Math.max(dp2[N-1-j]+1, dp2[N-1-i]);
                }
            }
        }

        int maxLen = 1;
        for(int i=0 ; i<N ; i++){
            maxLen = Math.max(maxLen, dp1[i] + dp2[i] - 1);
        }

        System.out.println(maxLen);
    }
}
