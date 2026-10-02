package day_09.BOJ_B1_11050;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int ans = 1;
        for(int i=1 ; i<=K ; i++){    // 조합 공식 위쪽
            ans *= N--;
        }
        for(int i=1 ; i<=K ; i++){    // 조합 공식 아래쪽
            ans /= i;
        }

        System.out.println(ans);    // 반복문 한번에 하면 안됨

        sc.close();
    }
}
