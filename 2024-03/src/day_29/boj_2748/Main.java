package day_29.BOJ_B1_2748;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long An_2 = 0;
        long An_1 = 1;
        long An = -1;
        if(n==0) An=An_2;
        else if(n==1) An=An_1;

        for(int i=2 ; i<=n ; i++){
            An = An_1 + An_2;
            An_2 = An_1;
            An_1 = An;
        }

        System.out.println(An);

        sc.close();
    }
}
