package day_26.BOJ_S5_2751;

import java.io.*;
import java.util.PriorityQueue;

public class Main_pq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0 ; i<N ; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
