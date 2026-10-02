package day_01.BOJ_G2_12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        int[] dp = new int[1+N];
        int maxLen = 0;

        for(int i=0 ; i<N ; i++){
            int idx = binarySearch(dp, 1, maxLen, A[i]);
            if(idx > maxLen){
                dp[++maxLen] = A[i];
            }
            else{
                dp[idx] = A[i];
            }
            System.out.println(Arrays.toString(dp));
            System.out.println(idx);
        }

        System.out.println(maxLen);
    }

    private static int binarySearch(int[] arr, int left, int right, int value){
        if(value > arr[right]) return right + 1;

        int mid = (left + right) / 2;

        while(left < right){
            if(value > arr[mid]){
                left = mid + 1;
            }
            else if(value < arr[mid]){
                right = mid;
            }
            else{
                break;
            }
            mid = (left + right) / 2;
        }

        return mid;
    }

}
