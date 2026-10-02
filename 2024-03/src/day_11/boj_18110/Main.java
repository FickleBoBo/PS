package day_11.BOJ_S4_18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i=0 ; i<n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int del = (int) Math.round(n * 0.15);
        int start = del;
        int end = n-1 - del;
        int sum = 0;
        for(int i=start ; i<=end ; i++){
            sum += arr[i];
        }

//        System.out.println(start);
//        System.out.println(end);
//        System.out.println(sum);

        System.out.println(Math.round(((float) sum / (n - 2 * del))));

        br.close();
    }
}
