package day_20.BOJ_S5_5648;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // EOF 까지 입력 받기
        while(true){
            String input = br.readLine();
            if(input == null) break;

            sb.append(input).append(" ");
        }

        st = new StringTokenizer(sb.toString());
        st.nextToken();

        PriorityQueue<Long> pq = new PriorityQueue<>();

        while(st.hasMoreTokens()){
            sb = new StringBuilder(st.nextToken());
            pq.offer(Long.parseLong(sb.reverse().toString()));
        }

        sb = new StringBuilder();
        while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
