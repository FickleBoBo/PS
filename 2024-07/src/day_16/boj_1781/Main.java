package day_16.BOJ_G2_1781;

import java.io.*;
import java.util.*;

public class Main {

    static class Node{
        int deadLine;
        int cnt;

        public Node(int deadLine, int cnt) {
            this.deadLine = deadLine;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Node> deadLinePQ = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.deadLine, o1.deadLine)));
        int N = Integer.parseInt(br.readLine());

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            int deadLine = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());

            deadLinePQ.offer(new Node(deadLine, cnt));
        }

        PriorityQueue<Node> cntPQ = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2.cnt, o1.cnt)));
        int sum = 0;
        int date = deadLinePQ.peek().deadLine;

        while(date > 0){
            while(!deadLinePQ.isEmpty() && deadLinePQ.peek().deadLine >= date){
                cntPQ.offer(deadLinePQ.poll());
            }

            if(!cntPQ.isEmpty()){
                sum += cntPQ.poll().cnt;
            }

            date--;
        }

        System.out.println(sum);
    }
}
