package day_15.BOJ_S5_10815;

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
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<M ; i++){
            // 해당 원소가 배열에 존재하면 인덱스를 반환하고 존재하지 않으면 음수 반환
            int result = Arrays.binarySearch(arr, Integer.parseInt(st.nextToken()));

            if(result >= 0) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
