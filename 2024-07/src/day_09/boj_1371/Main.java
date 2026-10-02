package day_09.BOJ_B2_1371;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str;
        int[] cntArr = new int[26];

        while((str = br.readLine()) != null){
            st = new StringTokenizer(str);
            while(st.hasMoreTokens()){
                char[] input = st.nextToken().toCharArray();
                for(char c : input){
                    cntArr[c - 'a']++;
                }
            }
        }

        int max = 0;
        for(int i=0 ; i<26 ; i++){
            max = Math.max(max, cntArr[i]);
        }

        for(int i=0 ; i<26 ; i++){
            if(cntArr[i] == max){
                sb.append((char) (i + 'a'));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
