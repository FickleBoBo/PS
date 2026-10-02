package day_25.BOJ_S5_11931;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        for(int i=0 ; i<N ; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        for(int i=N-1 ; i>=0 ; i--){
            bw.write(nums[i] + "\n");
        }

        br.close();
        bw.close();
    }
}
