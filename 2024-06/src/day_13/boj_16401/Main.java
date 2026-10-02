package day_13.BOJ_S2_16401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearchUpperBound(arr, 1, 1000000000, M));
    }

    private static int binarySearchUpperBound(int[] arr, int left, int right, int target){
        int N = arr.length;

        while(left < right){
            int mid = (left + right) / 2;

            int cnt = 0;
            for(int i=0 ; i<N ; i++){
                cnt += arr[i] / mid;
            }

            if(cnt >= target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }

        return right - 1;
    }

}
