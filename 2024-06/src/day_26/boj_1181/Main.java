package day_26.BOJ_S5_1181;

import java.io.*;
import java.util.*;

public class Main_Comparator {

    static class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length());
            }
            return o1.compareTo(o2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for(int i=0 ; i<N ; i++) {
            set.add(br.readLine());
        }

        List<String> list = new ArrayList<>(set);

        MyComparator myComparator = new MyComparator();

        Collections.sort(list, myComparator);

        for(String s : list){
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
