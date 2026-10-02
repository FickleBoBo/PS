package day_16.BOJ_B3_10833;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][2];
        for(int i=0 ; i<N ; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int ans = 0;
        for(int i=0 ; i<N ; i++){
            ans += arr[i][1] % arr[i][0];
        }

        System.out.println(ans);
    }
}
