package day_27.BOJ_B3_4153;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            String input = br.readLine();
            if(input.charAt(0) == '0') break;

            int[] arr = new int[3];
            st = new StringTokenizer(input);
            for(int i=0 ; i<3 ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            if(arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]){
                bw.write("right\n");
            }
            else{
                bw.write("wrong\n");
            }
        }

        bw.flush();
    }
}
