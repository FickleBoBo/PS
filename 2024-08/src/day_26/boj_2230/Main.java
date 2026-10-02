package day_26.BOJ_G5_2230;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;

        while(true){
            int diff = arr[right] - arr[left];

            if(diff >= M){
                ans = Math.min(ans, diff);
                left++;
            }
            else{
                right++;
            }

            if(right == N || left > right) break;
        }

        System.out.println(ans);
    }
}
