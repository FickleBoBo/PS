package day_26.BOJ_B2_2750;

import java.io.*;
import java.util.PriorityQueue;

public class Main_pq {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0 ; i<N ; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while(!pq.isEmpty()){
            bw.write(pq.poll() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
