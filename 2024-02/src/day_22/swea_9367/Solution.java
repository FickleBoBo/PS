package day_22.SWEA_D1_9367;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=1 ; tc<=T ; tc++){

            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0 ; i<N ; i++){
                arr[i] = sc.nextInt();
            }

            int max = 1;
            int cnt = 1;
            for(int i=0 ; i<N-1 ; i++){
                if(arr[i] < arr[i+1]){
                    cnt++;
                }
                else{
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
            System.out.printf("#%d %d\n", tc, max);
        }
        sc.close();
    }
}
