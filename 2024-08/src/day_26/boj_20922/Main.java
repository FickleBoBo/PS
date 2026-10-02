package day_26.BOJ_S1_20922;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cntArr = new int[1 + 100_000];

        int left = 0;
        int right = 0;
        int ans = 0;

        while(true){
            if(cntArr[arr[right]] < K){
                cntArr[arr[right]]++;
                right++;
                ans = Math.max(ans, right - left);
            }
            else{
                cntArr[arr[left]]--;
                left++;
            }

            if(right == N) break;
        }

        System.out.println(ans);
    }
}
