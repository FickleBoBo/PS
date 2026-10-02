package day_29.BOJ_S2_2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            sb.append(br.readLine()+" ");
        }

        StringTokenizer st = new StringTokenizer(sb.toString(), " ");

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while(st.hasMoreTokens()){
            pq.offer(Integer.parseInt(st.nextToken()));
            if(pq.size() > N) pq.poll();
        }

        System.out.println(pq.poll());

        br.close();
    }
}
