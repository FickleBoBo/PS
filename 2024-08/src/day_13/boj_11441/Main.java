package day_13.BOJ_S3_11441;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[1+N];
        int[] prefixSum = new int[1+N];

        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0 ; i<M ; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());

            sb.append(prefixSum[b] - prefixSum[a]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
