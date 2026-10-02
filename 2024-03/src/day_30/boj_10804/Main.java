package day_30.BOJ_B2_10804;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[20];
        for(int i=0 ; i<20 ; i++){
            arr[i] = i+1;
        }

        Scanner sc = new Scanner(System.in);

        for(int i=0 ; i<10 ; i++){
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            for(int j=a ; j<=(a+b)/2 ; j++){
                int tmp = arr[j];
                arr[j] = arr[b+a-j];
                arr[b+a-j] = tmp;
            }
        }

        for(int i=0 ; i<20 ; i++){
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
