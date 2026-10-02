package day_29.BOJ_S2_11279;

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

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());

            if(n>0) pq.offer(n);
            else{
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }
        }

        br.close();
    }
}
