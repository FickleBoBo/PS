package day_19.BOJ_S2_1927;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        for(int i=0 ; i<N ; i++){
            int x = Integer.parseInt(br.readLine());

            if(x > 0){
                pq.offer(x);
            }
            else{
                if(pq.isEmpty()){
                    sb.append(0).append("\n");

                }
                else{
                    sb.append(pq.poll()).append("\n");

                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
