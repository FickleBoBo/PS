package day_06.BOJ_G2_1202;

import java.io.*;
import java.util.*;

public class Main {

    // 보석 클래스
    static class Jewel{
        int m;
        int v;

        public Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 1. 입력으로 주어지는 보석을 무게에 대한 오름차순으로 정렬하는 우선순위 큐에 담는다
        PriorityQueue<Jewel> jewels = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.m, o2.m)));

        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m, v));
        }

        // 2. 가방을 배열에 담아 무게에 대한 오름차순으로 정렬한다
        int[] knapsacks = new int[K];

        for(int i=0 ; i<K ; i++){
            knapsacks[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(knapsacks);

        // 3. 보석 가격의 총 합으로 오버플로우 주의(테스트 케이스 3%)
        long sum = 0;

        // 4. 보석의 가격에 대한 내림차순으로 정렬하는 우선순위 큐를 만든다
        // 동작원리는 담을 수 있는 최대 무게에 대해 오름차순으로 정렬된 가방배열에서 각각의 가방에 담을 수 있는 보석들을 전부 pq에 담는다
        // 그러면 i번 가방에 담을 수 있는 보석들이 pq에 다 들어가게 되고 pq에서 가격이 가장 비싼 보석이 맨 앞에 있게 된다
        // 해당 가방에 pq.poll을 담는 과정을 반복한다고 생각하면 된다
        // 다만 pq가 비어있을 경우 건너뛰는 조건이 필요하다(= 해당 가방에 담을 보석이 없음)
        PriorityQueue<Jewel> pq = new PriorityQueue<>(((o1, o2) -> -Integer.compare(o1.v, o2.v)));

        for(int i=0 ; i<K ; i++){
            while(!jewels.isEmpty() && jewels.peek().m <= knapsacks[i]){
                pq.offer(jewels.poll());
            }

            // NullPointer 에러 발생할 수 있음(테스트 케이스 3%)
            if(pq.isEmpty()) continue;
            sum += pq.poll().v;
        }

        System.out.println(sum);
    }

}
