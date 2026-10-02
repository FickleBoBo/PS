package day_22.BOJ_G5_12865;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1D {

    // 물건의 무게(w)와 가치(v)를 담는 클래스
    static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 물건들을 저장하는 배열로 물건이 없는 경우를 위해 패딩을 해준다
        Item[] items = new Item[1+N];
        for(int i=1 ; i<=N ; i++){
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items[i] = new Item(w, v);
        }

        // 1 ~ N번째 물건까지 중 j의 무게로 만들 수 있는 최대 가치를 저장하는 1차원 dp 테이블
        int[] dp = new int[1+K];

        // 1번째 물건부터 i번째 물건까지 선택할 수 있을 때
        for(int i=1 ; i<=N ; i++){

            // 뒤에서부터 갱신하며 물건의 무게까지만 반복하면 물건을 넣을 수 없는 경우도 고려안해도 됨
            // 정방향 순위할 경우 기존의 값이 뒤의 값에 영향을 미치게 됨( 0/1 배낭 문제 )
            for(int j=K ; j>=items[i].w ; j--){

                // i번째 물건을 담을 수 있는 경우 최대 가치 비교
                // 최대 가치는 i번째 물건을 안 담는 경우와, i번째 물건을 담는 경우를 비교
                // i번째 물건을 안 담는 경우의 배낭 무게는 j, i번째 물건을 담는 경우 배낭 무게는 j - i.w 에서 비교
                dp[j] = Math.max(dp[j], dp[j-items[i].w] + items[i].v);
            }
        }

        System.out.println(dp[K]);
    }
}
