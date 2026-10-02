package day_12.BOJ_B2_2292;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();            // N : 칸 수를 찾을 숫자 입력 받음(int형 범위 만족)

        int n = 0;                       // n : 점화식의 항 숫자이자 이동 칸수
        int Sn = 1;                      // Sn = 1 : 점화식의 첫번째 항
        while (N > Sn) {                 // 조건에 등호를 넣어서 5분 정도 헤맴
            n++;                         // 갱신
            Sn = 3 * n * (n + 1) + 1;    // 갱신
        }

        System.out.println(n + 1);       // 시작 칸부터 1을 세기 때문에 한 칸 더해줘야 함
        sc.close();
    }
}