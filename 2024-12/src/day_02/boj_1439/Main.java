package day_02.BOJ_1439;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringTokenizer st0 = new StringTokenizer(input, "0");
        StringTokenizer st1 = new StringTokenizer(input, "1");

        System.out.println(Math.min(st0.countTokens(), st1.countTokens()));
    }
}
