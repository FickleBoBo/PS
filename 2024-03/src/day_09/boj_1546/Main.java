package day_09.BOJ_B1_1546;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] nums = new int[N];
        int sum = 0;

        for(int i=0 ; i<N ; i++){
            nums[i] = sc.nextInt();
            sum += nums[i];
        }

        Arrays.sort(nums);
        double M = nums[N-1];

        System.out.println(sum / M / N * 100);    // double이 중간에 껴야함

        sc.close();
    }
}
