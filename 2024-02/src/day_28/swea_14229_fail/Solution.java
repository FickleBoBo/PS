package day_28.SWEA_D2_14229_Fail;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] nums;

    public static void main(String[] args) throws IOException {

        // 퀵정렬 구현 실패

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("month_02/src/day_28/SWEA_D2_14229/input.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        nums = new int[1_000_000];

        int i = 0;
        while(st.hasMoreTokens()){
            nums[i++] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, nums.length-1);

        System.out.println(nums[500_000]);

        br.close();
    }

    static void quickSort(int left, int right) {

        if(left >= right){
            return;
        }

        int pivot = partition(left, right);

        quickSort(left, pivot-1);
        quickSort(pivot+1, right);
    }

    // Hoare Partition
    static int partition(int left, int right) {

        int pivot = left;
        int L = left + 1;
        int R = right;

        while(L < R){

            while((L < R) && (nums[L] < nums[pivot])){
                L++;
            }

            while(nums[R] > nums[pivot]){
                R--;
            }

            if(L < R){
                int tmp = nums[L];
                nums[L] = nums[R];
                nums[R] = tmp;
            }
        }

        if(nums[pivot] > nums[R]){
            int tmp = nums[R];
            nums[R] = nums[pivot];
            nums[pivot] = tmp;
        }

        return R;
    }

}