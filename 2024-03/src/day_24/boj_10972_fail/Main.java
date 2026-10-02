package day_24.BOJ_S3_10972_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(true){
            boolean swaped = false;
            for(int i=N-1 ; i>0 ; i--){
                if(arr[i] > arr[i-1]){
                    int tmp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = tmp;
                    swaped = true;
                    Arrays.sort(arr, i, N);
                    break;
                }
            }

            if(swaped){
                for(int n : arr){
                    System.out.print(n + " ");
                }
                System.out.println();
            }
            else{
                System.out.println(-1);
                break;
            }
        }


    }
}
