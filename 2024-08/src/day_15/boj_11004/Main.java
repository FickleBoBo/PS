package day_15.BOJ_S5_11004;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=K ; i<=N ; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        for(int i=1 ; i<K ; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
            pq.poll();
        }

        System.out.println(pq.poll());
    }
}
