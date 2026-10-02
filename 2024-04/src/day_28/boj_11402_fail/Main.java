package day_28.BOJ_P4_11402_Fail;

import java.util.Scanner;

public class Main {

    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long K = sc.nextLong();
        M = sc.nextInt();

        System.out.println(comb(N, K) % M);

        sc.close();
    }

    private static long comb(long n, long k){
        if(k==0) return n;
        else if(k==n) return 1;
        return (comb(n-1, k) + comb(n-1, k-1)) % M;
    }

}
