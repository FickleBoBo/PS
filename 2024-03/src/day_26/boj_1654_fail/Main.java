package day_26.BOJ_S2_1654_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[] arr = new int[K];
        for(int i=0 ; i<K ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int num = arr[0];

        while(true){
            int cnt = 0;
            for(int i=0 ; i<K ; i++){
                cnt += arr[i] / num;
            }
            if(cnt >= N){
                break;
            }
            num--;
        }

        System.out.println(num);

        br.close();
    }
}
