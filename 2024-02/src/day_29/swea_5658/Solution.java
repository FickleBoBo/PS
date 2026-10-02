package day_29.SWEA_모의SW역량테스트_5658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            char[] nums = br.readLine().toCharArray();

            for(int i=0 ; i<7 ; i++){
                calculateNums(nums);
                nums = rotateNums(nums);
            }


            int[] ans = new int[list.size()];
            for(int i=0 ; i<list.size() ; i++){
                ans[i] = list.get(i);
            }
            Arrays.sort(ans);
//            System.out.println(Arrays.toString(ans));
//            System.out.println(list.size());
//            System.out.println(K);
            System.out.printf("#%d %d\n", tc, ans[list.size()-K]);
            list.clear();
        }

        br.close();
    }

    static char[] rotateNums(char[] arr){
        char tmp = arr[arr.length-1];
        for(int i=arr.length-2 ; i>=0 ; i--){
            arr[i+1] = arr[i];
        }
        arr[0] = tmp;
        return arr;
    }

    static void calculateNums(char[] arr){
        int N = arr.length;
        int len = N / 4;
        int[] nums = new int[N];
        for(int i=0 ; i<N ; i++){
            nums[i] = Character.getNumericValue(arr[i]);
        }

//        System.out.println(Arrays.toString(nums));

        for(int n=0 ; n<4 ; n++){
            int value = 0;
            int mul = (int) Math.pow(16, len);
            for(int i=len*n ; i<len*n+len ; i++){
                mul /= 16;
                value += nums[i] * mul;
            }
//            list.add(value);
            if(!list.contains(value)){
                list.add(value);
            }
        }
    }

}
