package day_07.BOJ_B4_28074;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cntArr = new int[26];

        char[] input = br.readLine().toCharArray();
        for(char c : input){
            cntArr[c - 'A']++;
        }

        if(cntArr[1] != 0 && cntArr[8] != 0 &&cntArr[12] != 0 &&cntArr[14] != 0 &&cntArr[18] != 0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
