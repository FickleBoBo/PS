package day_28.BOJ_B1_2947;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        for(int i=0 ; i<5 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0 ; i<4 ; i++){
            for(int j=0 ; j<4-i ; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    for(int k=0 ; k<5 ; k++){
                        sb.append(arr[k]).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
