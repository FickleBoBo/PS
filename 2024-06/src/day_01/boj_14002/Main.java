package day_01.BOJ_G2_14002;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0 ; i<N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        for(int i=0 ; i<N ; i++){
            dp[i] = 1;    // 자기 자신이 길이 1짜리 부분 수열이 되므로 최소 1
            for(int j=0 ; j<i ; j++){
                // 자신보다 작은 원소의 LIS와 비교해서 갱신
                if(A[j] < A[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        // 최대 길이와 최대 길이일 때의 인덱스를 찾음
        int maxLen = 1;
        int maxLenIdx = 0;
        for(int i=0 ; i<N ; i++){
            if(dp[i] > maxLen){
                maxLen = dp[i];
                maxLenIdx = i;
            }
        }

        // 실제 LIS를 저장할 배열로 dp 테이블을 역순으로 돌며 찾아나감
        int[] lis = new int[maxLen];
        int idx = maxLen - 1;
        for(int i=maxLenIdx ; i>=0 ; i--){
            if(dp[i] == maxLen){
                lis[idx] = A[i];
                maxLen--;
                idx--;
            }
        }

        bw.write(lis.length + "\n");
        for(int n : lis){
            bw.write(n + " ");
        }
        bw.flush();
        bw.close();
    }
}
