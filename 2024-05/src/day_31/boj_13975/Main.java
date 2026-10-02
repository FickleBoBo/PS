package day_31.BOJ_G4_13975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc=1 ; tc<=T ; tc++){
            PriorityQueue<Long> pq = new PriorityQueue<>();

            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long ans = 0;
            while(pq.size() > 1){
                long A = pq.poll();
                long B = pq.poll();
                ans += A + B;
                pq.offer(A + B);
            }

            System.out.println(ans);
        }

    }
}
