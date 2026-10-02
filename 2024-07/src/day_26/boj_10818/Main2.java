package day_26.BOJ_B3_10818;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++) arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        sb.append(arr[0]).append(" ").append(arr[N-1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
