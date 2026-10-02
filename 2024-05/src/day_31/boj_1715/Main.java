package day_31.BOJ_G4_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 카드 묶음의 크기가 가장 작은 것을 뽑기 위해 우선순위 큐 이용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int i=0 ; i<N ; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int ans = 0;

        // 남은 카드 뭉치가 하나인 경우가 종료 조건이며 N=1 인 반례도 처리 가능
        while(pq.size() > 1){
            int A = pq.poll();
            int B = pq.poll();
            ans += A + B;
            pq.offer(A+B);    // 정답을 갱신하고 다시 우선순위큐에 합친 뭉치를 넣어줌
        }

        System.out.println(ans);
    }
}
