package day_01.BOJ_11478;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length() + 1; j++) {
                set.add(input.substring(i, j));
            }
        }

        System.out.println(set.size());
    }
}
