package day_22.BOJ_P4_12920;

import java.io.*;
import java.util.*;

public class Main_2D {

    // 물건의 무게(v)와 가치(k)를 담는 클래스
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

            // 인덱스를 맞춰주기 위해 더미 노드 추가
            itemList.add(0, new Item(0, 0));
        }

        // 더미 노드를 고려해서 인덱스를 위한 변수 len 초기화
        int len = itemList.size() - 1;

        // 2차원 dp 테이블로 해결
        int[][] dp = new int[1+len][1+M];

        for(int i=1 ; i<=len ; i++){
            for(int j=1 ; j<=M ; j++){
                if(j < itemList.get(i).v){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-itemList.get(i).v] + itemList.get(i).c);
                }
            }
        }

        System.out.println(dp[len][M]);
    }
}
