package day_14.BOJ_1181;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);

        list.sort(((o1, o2) -> {
            if (o1.length() != o2.length()) return Integer.compare(o1.length(), o2.length());
            return o1.compareTo(o2);
        }));

        for (String str : list) {
            sb.append(str).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
