package day_01.BOJ_P5_14003;

import java.io.*;
import java.util.Arrays;
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

        int[] dp = new int[1+N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int maxLen = 0;
        int[] result = new int[N];

        for(int i=0 ; i<N ; i++){
            int idx = binarySearch(dp, 1, maxLen, A[i]);
            if(idx > maxLen){
                dp[++maxLen] = A[i];
            }
            else{
                dp[idx] = A[i];
            }
            result[i] = idx;
//            System.out.println(Arrays.toString(dp));
//            System.out.println(idx);
//            System.out.println(Arrays.toString(result));
        }

        bw.write(maxLen + "\n");
        int[] lis = new int[maxLen];
        int idx = 0;
        for(int i=N-1 ; i>=0 ; i--){
            if(result[i] == maxLen){
                lis[idx] = A[i];
                idx++;
                maxLen--;
            }
        }
        for(int i=lis.length-1 ; i>=0 ; i--){
            bw.write(lis[i] + " ");
        }
        bw.flush();
        bw.close();
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
