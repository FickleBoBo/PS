package day_27.BOJ_G4_1253;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;

        for(int i=0 ; i<N ; i++){
            int left = 0;
            int right = N-1;

            if(left == i) left++;
            else if(right == i) right--;

            while(left < right){
                int sum = arr[left] + arr[right];

                if(sum < arr[i]){
                    left++;
                    if(left == i) left++;
                }
                else if(sum > arr[i]){
                    right--;
                    if(right == i) right--;
                }
                else{
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}
