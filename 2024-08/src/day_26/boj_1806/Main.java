package day_26.BOJ_G4_1806;

import java.io.*;
import java.util.*;

public class Main {
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

        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        while(true){
            if(sum < S){
                sum += arr[right];
                right++;
            }
            else{
                sum -= arr[left];
                ans = Math.min(ans, right - left);
                left++;
            }

            // 71% 테스트 케이스
            if(sum < S && right == N) break;
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}
