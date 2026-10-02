package day_27.BOJ_S4_2003;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int cnt = 0;

        while(true){
            if(sum < M){
                sum += arr[right];
                right++;
            }
            else if(sum > M){
                sum -= arr[left];
                left++;
            }
            else{
                cnt++;
                sum -= arr[left];
                left++;
            }

            if(sum < M && right == N) break;
        }

        System.out.println(cnt);
    }
}
