package day_02.BOJ_S1_14225;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0 ; i<N ; i++){
            nums[i] = sc.nextInt();
        }
        int[] naturalNums = new int[2_000_000];

        for(int i=1 ; i<(1<<N) ; i++){
            int sum = 0;
            for(int j=0 ; j<N ; j++){
                if((i & (1<<j)) > 0){
                    sum += nums[j];
                }
            }
            naturalNums[sum]++;
        }

        for(int i=1 ; i<naturalNums.length ; i++){
            if(naturalNums[i] == 0){
                System.out.println(i);
                break;
            }
        }

        sc.close();
    }
}
