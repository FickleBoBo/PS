package day_11.BOJ_S5_11650;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] nums = new int[N][2];

        for(int i=0 ; i<N ; i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        // Lambda Expression Comparator
        Arrays.sort(nums, ((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }));

        for(int i=0 ; i<N ; i++){
            System.out.println(nums[i][0] + " " + nums[i][1]);
        }

    }
}
