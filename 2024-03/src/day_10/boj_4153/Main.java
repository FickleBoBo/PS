package day_10.BOJ_B3_4153;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        nums[0] = sc.nextInt();
        nums[1] = sc.nextInt();
        nums[2] = sc.nextInt();
        Arrays.sort(nums);    // 입력이 오름차순은 아님
        while(nums[0] > 0){    // 종료 조건
            if(nums[0]*nums[0] + nums[1]*nums[1] == nums[2]*nums[2]){
                System.out.println("right");
            }
            else{
                System.out.println("wrong");
            }
            nums[0] = sc.nextInt();
            nums[1] = sc.nextInt();
            nums[2] = sc.nextInt();
            Arrays.sort(nums);
        }
        sc.close();
    }
}
