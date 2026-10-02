package day_04.SWEA_D2_1859;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/day_04/SWEA_D2_1859/input.txt")));
        int T = Integer.parseInt(br.readLine());

        for(int tc=1 ; tc<=T ; tc++){
            int N = Integer.parseInt(br.readLine());

            int[] nums = new int[N];
            String[] tmp = br.readLine().split(" ");

            for(int i=0 ; i<N ; i++){
                nums[i] = Integer.parseInt(tmp[i]);
            }

            int startIdx = 0;
            long ans = 0;

            while(true) {
                int max = 0;
                int maxIdx = -1;

                for(int i=startIdx ; i<N ; i++){
                    if(nums[i] >= max){
                        max = nums[i];
                        maxIdx = i;
                    }
                }

                for(int i=startIdx ; i<maxIdx ; i++){
                    ans += max-nums[i];
                }

                if(maxIdx == N-1){
                    break;
                }

                startIdx = maxIdx + 1;

            }

            System.out.printf("#%d %d\n", tc, ans);

        }
        br.close();
    }
}
