package day_19.BOJ_B2_8320;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 정사각형이 n개 있을 때
        // 높이 1인 직사각형은 n/1-0 개 만들 수 있음
        // 높이 2인 직사각형은 n/2-1 개 만들 수 있음
        // 높이 3인 직사각형은 n/3-2 개 만들 수 있음
        // 일반항 ak = n/k-l+1 (ak >= 1)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();          // n : 변의 길이가 1인 정사각형의 개수
        int ans = 0;                   // ans : 이 정사각형을 이용해서 만들 수 있는 직사각형의 개수

        int N = (int) Math.sqrt(n);    // N : 직사각형 개수 점화식의 항 수
        for(int i=1 ; i<=N ; i++){
            ans += n/i-i+1;            // 점화식
        }
        System.out.println(ans);
        sc.close();
    }
}
