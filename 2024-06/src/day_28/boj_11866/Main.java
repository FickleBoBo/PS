package day_28.BOJ_S5_11866;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1 ~ N가지 Queue에 담음
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=1 ; i<=N ; i++){
            q.offer(i);
        }

        sb.append("<");
        while(!q.isEmpty()){
            // Queue에서 꺼내면서 집어 넣음
            for(int i=1 ; i<K ; i++){
                q.offer(q.poll());
            }

            // K번 째 수만 StringBuilder에 담음
            sb.append(q.poll()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
