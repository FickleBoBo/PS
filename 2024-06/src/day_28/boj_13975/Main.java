package day_28.BOJ_G4_13975;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            int K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            // int형 범위를 넘어갈 수 있다
            PriorityQueue<Long> pq = new PriorityQueue<>();
            while(st.hasMoreTokens()){
                pq.offer(Long.parseLong(st.nextToken()));
            }

            // int형 범위를 넘어갈 수 있다
            long ans = 0;

            while(pq.size() > 1){
                long peek = pq.poll() + pq.poll();
                ans += peek;
                pq.offer(peek);
            }

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
