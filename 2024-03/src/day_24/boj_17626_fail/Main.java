package day_24.BOJ_S3_17626_Fail;

import java.util.Scanner;

public class Main {

    static int ans = 4;
    static int[] DP = new int[50000];
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Lagrange(n, 0);
        System.out.println(ans);
    }

    private static void Lagrange(int num, int cnt){
        if(cnt > 4){
            return;
        }
        else if(num == 0){
            ans = Math.min(ans, cnt);
            return;
        }
        else if(num < 0){
            return;
        }

        for(int i = (int) Math.sqrt(num); i>(int) (Math.sqrt(num)/4) ; i--){
            Lagrange(num-i*i, cnt+1);
        }

    }
}
