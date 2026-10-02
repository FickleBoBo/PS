package day_02.BOJ_S2_6603;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] set;
    static int[] sel;
    static int k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        while(!(input[0].equals("0"))){
            k = Integer.parseInt(input[0]);
            set = new int[k];
            sel = new int[6];
            for(int i=0 ; i<k ; i++){
                set[i] = Integer.parseInt(input[i+1]);
            }

            combination(0, 0);
            System.out.println();

            input = sc.nextLine().split(" ");
//            System.out.println(Arrays.toString(input));
        }
        sc.close();
    }

    static void combination(int idx, int sidx) {
        // 종료 조건
        if(sidx == 6){
            for(int i=0 ; i<6 ; i++){
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }

        // 재귀 조건
        for(int i=idx ; i<k ; i++){
            sel[sidx] = set[i];
            combination(i+1, sidx+1);
        }
    }
}
