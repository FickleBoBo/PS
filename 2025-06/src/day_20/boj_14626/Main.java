package day_20.BOJ_14626;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int sum = 0;  // ISBN 13자리의 가중치를 포함한 합(훼손된 숫자 제외)
        int weight = -1;  // 훼손된 숫자의 계수
        for (int i = 0; i < 13; i++) {
            char c = input.charAt(i);
            if (c == '*') {
                weight = i % 2 == 0 ? 1 : 3;
                continue;
            }

            if (i % 2 == 0) {
                sum += Character.getNumericValue(c);
            } else {
                sum += Character.getNumericValue(c) * 3;
            }
        }

        // 0 ~ 9에서 훼손된 숫자 찾기
        for (int i = 0; i < 10; i++) {
            if ((sum + weight * i) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }

        br.close();
    }
}
