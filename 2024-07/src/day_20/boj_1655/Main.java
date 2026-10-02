package day_20.BOJ_G2_1655;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 말해야 하는 값을 포함한 앞부분(최대힙)
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        // 뒷부분(최소힙)
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        // 처음 하나는 null 방지용으로 바로 사용
        pq1.offer(Integer.parseInt(br.readLine()));
        sb.append(pq1.peek()).append("\n");

        for(int i=1 ; i<N ; i++){
            int num = Integer.parseInt(br.readLine());

            // 크기가 같으면 pq1에 추가하는게 기본
            if(pq1.size() == pq2.size()){
                if(pq2.peek() < num){
                    pq1.offer(pq2.poll());
                    pq2.offer(num);
                }
                else{
                    pq1.offer(num);
                }
            }
            // 크기가 다르면 pq2에 추가하는게 기본
            else{
                if(pq1.peek() < num){
                    pq2.offer(num);
                }
                else{
                    pq2.offer(pq1.poll());
                    pq1.offer(num);
                }
            }
            sb.append(pq1.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
