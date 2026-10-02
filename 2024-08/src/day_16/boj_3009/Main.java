package day_16.BOJ_B3_3009;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Integer> xpos = new ArrayList<>();
        List<Integer> ypos = new ArrayList<>();

        for(int i=1 ; i<=3 ; i++){
            st = new StringTokenizer(br.readLine());

            Integer x = Integer.valueOf(st.nextToken());
            Integer y = Integer.valueOf(st.nextToken());

            if(xpos.contains(x)) xpos.remove(x);
            else xpos.add(x);

            if(ypos.contains(y)) ypos.remove(y);
            else ypos.add(y);
        }

        sb.append(xpos.get(0)).append(" ").append(ypos.get(0));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
