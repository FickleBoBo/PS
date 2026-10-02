package day_21.BOJ_B2_2577;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int mul = 1;
        for(int i=1 ; i<=3 ; i++){
            mul *= Integer.parseInt(br.readLine());
        }

        // 숫자가 몇 번 쓰였는지 저장하는 카운팅 배열(인덱스 번호 == 사용한 숫자)
        int[] cntArr = new int[10];

        // int -> String 으로 타입을 변환하면 String의 메서드를 사용할 수 있어 가독성이 좀 더 좋아짐
        String mulToString = String.valueOf(mul);

        for(int i=0 ; i<mulToString.length() ; i++){
            cntArr[mulToString.charAt(i) - '0']++;
        }

        for(int i=0 ; i<10 ; i++){
            sb.append(cntArr[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
