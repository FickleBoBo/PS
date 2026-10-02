package day_07.BOJ_18870;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new TreeSet<>(list);
        Map<Integer, Integer> map = new HashMap<>();
        int order = 0;
        for (int n : set) {
            map.put(n, order++);
        }

        for (int n : list) {
            sb.append(map.get(n)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
