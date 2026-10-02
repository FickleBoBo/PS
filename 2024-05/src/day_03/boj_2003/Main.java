package day_03.BOJ_S4_2003;

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

        int start = 0;
        int end = 0;
        int sum = arr[0];

        int ans = 0;
        while(true){
            if(sum < M){
                sum += arr[++end];
            }
            else if(sum > M){
                sum -= arr[start++];
            }
            else{
                ans++;
                if(end < N-1){
                    sum += arr[++end];
                }
                sum -= arr[start++];
            }

            if(end>=N-1 && sum<M) break;
        }

        System.out.println(ans);

    }
}
