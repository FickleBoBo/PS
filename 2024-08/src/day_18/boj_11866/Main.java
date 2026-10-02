package day_18.BOJ_S5_11866;

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

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=1 ; i<=N ; i++){
            q.offer(i);
        }

        sb.append("<");
        while(!q.isEmpty()){
            for(int i=1 ; i<K ; i++){
                q.offer(q.poll());
            }

            sb.append(q.poll());
            if(!q.isEmpty()) sb.append(", ");
        }
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
    }
}
