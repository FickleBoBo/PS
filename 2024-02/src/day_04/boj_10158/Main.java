package day_04.BOJ_S3_10158;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int t = sc.nextInt();

        int tx = (t + p) % (2 * w);    // 좌표의 주기성을 이용한 계산식
        int x = tx > w ? 2 * w - tx : tx;    // 너비를 초과할 경우를 구분해 계산

        int ty = (t + q) % (2 * h);    // 좌표의 주기성을 이용한 계산식
        int y = ty > h ? 2 * h - ty : ty;    // 높이를 초과할 경우를 구분해 계산

        System.out.print(x + " " + y);
    }
}