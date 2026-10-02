package day_02.BOJ_B3_2884;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();

        int newH = H - 1;
        int newM = M + 15;
        if(newH == -1) newH += 24;
        if(newM >= 60){
            newM -=60 ;
            newH += 1;
        }
        if(newH == 24) newH -= 24;

        System.out.println(newH + " " + newM);

    }
}
