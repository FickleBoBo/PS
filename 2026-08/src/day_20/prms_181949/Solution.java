package day_20.prms_181949;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (char c : br.readLine().toCharArray()) {
            if (Character.isLowerCase(c)) {
                System.out.print((char) (c - 'a' + 'A'));
            } else {
                System.out.print((char) (c - 'A' + 'a'));
            }
        }
    }
}
