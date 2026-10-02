package day_14.BOJ_11656;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();

        List<String> list = new ArrayList<>();
        for(int i = 0; i < S.length(); i++) {
            list.add(S.substring(i));
        }
        list.sort(Comparator.naturalOrder());

        for(String s : list) {
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
