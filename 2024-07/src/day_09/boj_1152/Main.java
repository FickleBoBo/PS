package day_09.BOJ_B2_1152;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();
        int cnt = 1;

        for(int i=0 ; i<input.length() ; i++){
            if(input.charAt(i) == ' ') cnt++;
        }

        System.out.println(input.isEmpty() ? 0 : cnt);
    }
}
