package day_19.BOJ_G2_1781_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Problem implements Comparable<Problem> {
        int deadLine;
        int reward;

        public Problem(int deadLine, int reward) {
            this.deadLine = deadLine;
            this.reward = reward;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.deadLine == o.deadLine){
                return Integer.compare(o.reward, this.reward);
            }
            return Integer.compare(this.deadLine, o.deadLine);
        }

        @Override
        public String toString() {
            return "Problem{" +
                    "deadLine=" + deadLine +
                    ", reward=" + reward +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Problem> pq = new PriorityQueue<>();

        int maxLen = 0;
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            pq.offer(new Problem(deadLine, reward));

            maxLen = Math.max(maxLen, deadLine);
        }

        PriorityQueue<Problem> pq2 = new PriorityQueue<>();
        int ans = 0;
        int date = 1;

        while(!pq.isEmpty()){


            while(!pq.isEmpty() && pq.peek().deadLine == date){
                System.out.println(pq.peek());
                pq2.offer(pq.poll());
            }

            while(pq2.size() > date){
                pq2.poll();
            }

            System.out.println(date);
            date++;
        }

        while(!pq2.isEmpty()){
            System.out.println("pq2.peek() = " + pq2.peek());
            ans += pq2.poll().reward;
        }
        System.out.println(ans);
    }
}
