package day_16.BOJ_G3_20366_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Snowman implements Comparable<Snowman> {
        int head;
        int body;
        int height;

        public Snowman(int head, int body, int height) {
            this.head = head;
            this.body = body;
            this.height = height;
        }

        public boolean diff(Snowman snowman){
            return this.head != snowman.head && this.body != snowman.head && this.head != snowman.body && this.body != snowman.body;
        }

        @Override
        public int compareTo(Snowman o) {
            return Integer.compare(this.height, o.height);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        PriorityQueue<Snowman> pq1 = new PriorityQueue<>();
        PriorityQueue<Snowman> pq2 = new PriorityQueue<>();
        for(int i=0 ; i<N-1 ; i++){
            for(int j=i+1 ; j<N ; j++){
                pq1.offer(new Snowman(i, j, arr[i] + arr[j]));
                pq2.offer(new Snowman(i, j, arr[i] + arr[j]));
            }
        }
        pq1.offer(new Snowman(N, N, Integer.MAX_VALUE));
        pq2.offer(new Snowman(N, N, Integer.MAX_VALUE));

        int ans = Integer.MAX_VALUE;
        while(!(pq1.size()==1 && pq2.size()==1)){
            Snowman s1 = pq1.peek();
            Snowman s2 = pq2.peek();
            int h1 = s1.height;
            int h2 = s2.height;

            if(h1 > h2){
                if(s1.diff(s2)){
                    ans = Math.min(ans, h1 - h2);
                }
                pq2.poll();
            }
            else if(h1 < h2){
                if(s1.diff(s2)){
                    ans = Math.min(ans, h2 - h1);
                }
                pq1.poll();
            }
            else{
                if(s1.diff(s2)){
                    ans = 0;
                    break;
                }
                Snowman tmp1 = pq1.poll();
                Snowman tmp2 = pq1.poll();
                if((!pq1.isEmpty() && !pq2.isEmpty()) && (pq1.peek().height > pq2.peek().height)){
                    pq2.offer(tmp2);
                }
                else if((!pq1.isEmpty() && !pq2.isEmpty()) && (pq1.peek().height < pq2.peek().height)){
                    pq1.offer(tmp1);
                }
            }
        }

        System.out.println(ans);
    }
}
