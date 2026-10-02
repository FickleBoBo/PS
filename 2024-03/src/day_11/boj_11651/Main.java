package day_11.BOJ_S5_11651;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i=0 ; i<N ; i++){
            String[] input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        // Lambda Expression Comparator
        Arrays.sort(arr, ((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            else{
                return o1[1] - o2[1];
            }
        }));

        for(int i=0 ; i<N ; i++){
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }

        br.close();
        bw.close();
    }
}
