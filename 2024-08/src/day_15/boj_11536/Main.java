package day_15.BOJ_S5_11536;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i=0 ; i<N ; i++){
            arr[i] = br.readLine();
        }

        if(isIncreasing(arr)){
            bw.write("INCREASING");
        }
        else if(isDecreasing(arr)){
            bw.write("DECREASING");
        }
        else{
            bw.write("NEITHER");
        }

        bw.flush();
        bw.close();
    }

    private static boolean isIncreasing(String[] arr){
        String[] tmp = arr.clone();
        Arrays.sort(tmp);

        for(int i=0 ; i<arr.length ; i++){
            if(!arr[i].equals(tmp[i])){
                return false;
            }
        }

        return true;
    }

    private static boolean isDecreasing(String[] arr){
        String[] tmp = arr.clone();
        Arrays.sort(tmp, Collections.reverseOrder());

        for(int i=0 ; i<arr.length ; i++){
            if(!arr[i].equals(tmp[i])){
                return false;
            }
        }

        return true;
    }
}
