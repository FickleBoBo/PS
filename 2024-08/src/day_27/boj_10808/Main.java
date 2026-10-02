package day_27.BOJ_B4_10808;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();

        // 인덱스 0은 a의 개수 ~ 인덱스 25는 z의 개수를 저장하는 카운팅 배열
        int[] cntArr = new int[26];

        // a(97) ~ z(122)까지 오름차순으로 아스키 코드가 부여되어 있어서 'a'를 빼면 0 ~ 25로 바꿀 수 있다
        for(char c : input){
            cntArr[c - 'a']++;
        }

        for(int n : cntArr){
            sb.append(n).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
