package day_29.BOJ_B3_2576;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[7];
        Arrays.fill(arr, Integer.MAX_VALUE);
        int sum = 0;
        for(int i=0 ; i<7 ; i++){
            int n = sc.nextInt();
            if(n%2 == 1){
                arr[i] = n;
                sum += n;
            }
        }

        Arrays.sort(arr);

        if(sum==0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(arr[0]);
        }

        sc.close();
    }
}
