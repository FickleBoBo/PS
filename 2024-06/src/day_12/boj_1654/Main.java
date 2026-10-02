package day_12.BOJ_S2_1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final long INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for(int i=0 ; i<K ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        long ans = binarySearch(arr, K, N, 1, INF);
        System.out.println(ans);
    }

    private static long binarySearch(int[] arr, int len, int key, long left, long right){
        long mid = (left + right) / 2;

        while(left <= right){
            long cnt = 0;
            for(int i=0 ; i<len ; i++){
                cnt += arr[i]/mid;
            }

            if(cnt < key){
                right = mid - 1;
            }
            else if(cnt >= key){
                left = mid + 1;
            }

            mid = (left + right) / 2;
        }

        return right;
    }

}
