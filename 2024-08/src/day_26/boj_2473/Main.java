package day_26.BOJ_G3_2473;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long minSum = Long.MAX_VALUE;
        long[] ans = new long[3];

        for(int i=0 ; i<N-2 ; i++){
            int left = i+1;
            int right = N-1;

            while(left < right){
                long sum = arr[i] + arr[left] + arr[right];

                if(Math.abs(sum) < Math.abs(minSum)){
                    minSum = sum;
                    ans[0] = arr[i];
                    ans[1] = arr[left];
                    ans[2] = arr[right];
                }

                if(sum > 0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }

        sb.append(ans[0]).append(" ").append(ans[1]).append(" ").append(ans[2]);

        bw.write(sb.toString());
        bw.flush();
    }
}
