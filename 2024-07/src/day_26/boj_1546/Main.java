package day_26.BOJ_B1_1546;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int max = 0;
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if(arr[i] > max) max = arr[i];
        }

        System.out.println((double) sum / max * 100 / N);
    }
}
