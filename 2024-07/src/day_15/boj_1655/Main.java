package day_15.BOJ_G2_1655;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        pq1.offer(Integer.parseInt(br.readLine()));
        sb.append(pq1.peek()).append("\n");

        for(int i=1 ; i<N ; i++){


            int n = Integer.parseInt(br.readLine());

            if(pq1.size() == pq2.size()){
                if(pq2.peek() < n){
                    pq1.offer(pq2.poll());
                    pq2.offer(n);
                }
                else{
                    pq1.offer(n);
                }
            }
            else{
                if(pq1.peek() < n){
                    pq2.offer(n);
                }
                else{
                    pq2.offer(pq1.poll());
                    pq1.offer(n);
                }
            }
            sb.append(pq1.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
