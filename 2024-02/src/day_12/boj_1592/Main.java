package day_12.BOJ_B2_1592;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt() - 1;           // 시작부터 1을 세므로 계산 편리를 위해 1을 빼줌
        int L = sc.nextInt();

        int lcm = getLCM(N, L);             // 최소공배수 리턴

        System.out.println(lcm / L * M);    // 최소공배수를 이동거리로 나누면 이동 횟수가 되고 여기에 M을 곱하면 총 이동 횟수가 된다

        sc.close();
    }

    public static int getGCD(int num1, int num2) {    // 최대 공약수 리턴
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }

    public static int getLCM(int num1, int num2) {    // 최소 공배수 리턴
        return num1 * num2 / getGCD(num1, num2);
    }

}