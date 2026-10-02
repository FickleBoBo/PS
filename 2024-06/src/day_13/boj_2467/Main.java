package day_13.BOJ_G5_2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N-1;
        int ans = Integer.MAX_VALUE;
        int ansStart = -1;
        int ansEnd = N;

        while(start < end){
            int sum = Math.abs(arr[start] + arr[end]);
            if(sum < ans){
                ans = sum;
                ansStart = arr[start];
                ansEnd = arr[end];
            }

            if(Math.abs(arr[start+1] + arr[end]) < Math.abs(arr[start] + arr[end-1])){
                start++;
            }
            else if(Math.abs(arr[start+1] + arr[end]) >= Math.abs(arr[start] + arr[end-1])){
                end--;
            }
        }

        System.out.println(ansStart + " " + ansEnd);
    }
}
