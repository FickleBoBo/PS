package day_22.BOJ_P4_12920;

import java.io.*;
import java.util.*;

public class Main_1D {

    // 물건의 무게(v)와 가치(c)를 담는 클래스
    static class Item {
        int v;
        int c;

        public Item(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 물건을 저장하는 리스트
        List<Item> itemList = new ArrayList<>();
        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // 여기가 핵심인데 k보다 작거나 같은 모든 2의 배수(1 포함)를 itemList에 저장하고 그만큼 k를 감소
            for(int j=1 ; j<=k ; j <<= 1){
                itemList.add(new Item(v * j, c * j));
                k -= j;
            }

            // 남은 k도 itemList에 추가해줌
            if(k > 0){
                itemList.add(new Item(v * k, c * k));
            }
        }

        // 1차원 dp 테이블로 해결
        int[] dp = new int[1+M];

        for(Item item : itemList){
            for(int j=M ; j>=item.v ; j--){
                dp[j] = Math.max(dp[j], dp[j-item.v] + item.c);
            }
        }

        System.out.println(dp[M]);
    }
}
