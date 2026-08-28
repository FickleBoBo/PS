package day_20.prms_181949;

import java.io.*;

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (char c : br.readLine().toCharArray()) {
            System.out.print((char) (c ^ 32));
        }
    }
}
