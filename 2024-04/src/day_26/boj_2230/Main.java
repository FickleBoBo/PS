package day_26.BOJ_G5_2230;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int diff = arr[end] - arr[start];
        int min = Integer.MAX_VALUE;

        if(N==1 || M==0) System.out.println(0);
        else{
            while(true){
                if(diff < M){
                    diff = arr[++end] - arr[start];
                }
                else{
                    min = Math.min(min, diff);
                    diff = arr[end] - arr[++start];
                }

                if(end == N-1 && diff < M) break;
            }

            System.out.println(min);
        }
        sc.close();
    }
}
