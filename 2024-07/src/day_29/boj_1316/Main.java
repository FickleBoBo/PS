package day_29.BOJ_S5_1316;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        out:
        for(int i=0 ; i<N ; i++){
            int[] checkArr = new int[26];
            Arrays.fill(checkArr, -1);

            String input = br.readLine();

            for(int j=0 ; j<input.length() ; j++){
                char c = input.charAt(j);

                if(checkArr[c - 'a'] == -1){
                    checkArr[c - 'a'] = j;
                }
                else{
                    if(checkArr[c - 'a'] == j - 1){
                        checkArr[c - 'a'] = j;
                    }
                    else{
                        continue out;
                    }
                }
            }

            cnt++;
        }

        System.out.println(cnt);
    }
}
