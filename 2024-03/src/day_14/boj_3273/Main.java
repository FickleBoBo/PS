package day_14.BOJ_S3_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[n];
        for(int i=0 ; i<n ; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int X = Integer.parseInt(br.readLine());

        Arrays.sort(nums);

        int idx = n-1;
        for(int i=n-1 ; i>=0 ; i--){
            if(nums[i] < X){
                idx = i;
                break;
            }
        }

        int cnt = 0;
        for(int i=0 ; i<idx ; i++){
            for(int j=i+1 ; j<=idx ; j++){
                if(nums[i] + nums[j] == X){
                    cnt++;
                }
                else if(nums[i] + nums[j] > X){
                    break;
                }
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
