package day_03.BOJ_B5_2744;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();

        // 'A'의 아스키 코드 65, 'a'의 아스키 코드 97, 알파벳 대문자와 소문자의 아스키 코드 차이는 32
        // char로 넣으려면 형변환 해줘야 함
        for(char c : input){
            if(c >= 'a' && c <= 'z'){
                sb.append((char) (c - 32));
            }
            else{
                sb.append((char) (c + 32));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
