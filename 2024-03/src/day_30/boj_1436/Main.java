package day_30.BOJ_S5_1436;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int num = 0;
        while(N!=0){
            if((num+"").contains("666")){
                N--;
            }
            num++;
        }

        System.out.println(num-1);

        sc.close();
    }
}
