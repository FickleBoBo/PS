package day_06.BOJ_1259;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            char[] input = br.readLine().toCharArray();
            if (input[0] == '0') break;

            boolean flag = palindrome(input);

            if (flag) sb.append("yes\n");
            else sb.append("no\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static boolean palindrome(char[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) return false;
        }

        return true;
    }

}
