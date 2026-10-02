package day_19.BOJ_S2_2075;

import java.io.*;
import java.util.*;

public class Main_PriorityQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 우선순위 큐에 N개를 일단 넣음
        st = new StringTokenizer(br.readLine());
        for(int j=0 ; j<N ; j++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i=1 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            // 우선순위 큐가 항상 N개를 유지해야 하므로 추가하면서 삭제
            for(int j=0 ; j<N ; j++){
                pq.offer(Integer.parseInt(st.nextToken()));
                pq.poll();
            }
        }

        // N번째로 큰 수가 우선순위 큐 맨 앞에 위치
        System.out.println(pq.poll());
    }
}
