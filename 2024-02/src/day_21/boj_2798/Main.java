package day_21.BOJ_B2_2798;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int ans = 0;

        int[] cards = new int[N];
        for(int i=0 ; i<N ; i++){
            cards[i] = sc.nextInt();
        }

        // 3중 for문으로 3개 더해서 max
        // i, j, k 의 순서를 유지하며 중복으로 뽑지 않는게 포인트
        for(int i=0 ; i<N-2 ; i++){
            for(int j=i+1 ; j<N-1 ; j++){
                for(int k=j+1 ; k<N ; k++){
                    if(cards[i] + cards[j] + cards[k] <= M){
                        ans = Math.max(ans, cards[i] + cards[j] + cards[k]);
                    }
                }
            }
        }

        System.out.println(ans);

        sc.close();
    }
}
