package day_29.BOJ_S1_11286;

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

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(((o1, o2) -> {
            return o2-o1;
        }));

        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());

            if(n > 0) pq1.offer(n);
            else if(n < 0) pq2.offer(n);
            else{
                if(pq1.isEmpty() && pq2.isEmpty()){
                    System.out.println(0);
                }
                else if(pq2.isEmpty()){
                    System.out.println(pq1.poll());
                }
                else if(pq1.isEmpty()){
                    System.out.println(pq2.poll());
                }
                else{
                    if(Math.abs(pq1.peek()) < Math.abs(pq2.peek())){
                        System.out.println(pq1.poll());
                    }
                    else{
                        System.out.println(pq2.poll());
                    }
                }
            }
        }

        br.close();
    }
}
