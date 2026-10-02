package day_22.BOJ_G5_12865;

import java.io.*;
import java.util.StringTokenizer;

public class Main_2D {

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

        // 1 ~ i번째 물건까지 중 j의 무게로 만들 수 있는 최대 가치를 저장하는 2차원 dp 테이블
        int[][] dp = new int[1+N][1+K];

        // 1번째 물건부터 i번째 물건까지 선택할 수 있을 때
        for(int i=1 ; i<=N ; i++){

            // 무게가 1부터 j 까지인 상황에서
            for(int j=1 ; j<=K ; j++){

                // i번째 물건의 무게가 배낭의 무게 j보다 크면 i번째 물건은 담을 수 없다
                if(j < items[i].w){
                    dp[i][j] = dp[i-1][j];
                }
                // i번째 물건을 담을 수 있는 경우 최대 가치 비교
                // 최대 가치는 i번째 물건을 안 담는 경우와, i번째 물건을 담는 경우를 비교
                // i번째 물건을 안 담는 경우의 배낭 무게는 j, i번째 물건을 담는 경우 배낭 무게는 j - i.w 에서 비교
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-items[i].w] + items[i].v);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
