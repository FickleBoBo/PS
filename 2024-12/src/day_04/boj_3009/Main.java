package day_04.BOJ_3009;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] xpos = new int[3];
        int[] ypos = new int[3];

        st = new StringTokenizer(br.readLine());
        xpos[0] = Integer.parseInt(st.nextToken());
        ypos[0] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        xpos[1] = Integer.parseInt(st.nextToken());
        ypos[1] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        xpos[2] = Integer.parseInt(st.nextToken());
        ypos[2] = Integer.parseInt(st.nextToken());

        Arrays.sort(xpos);
        Arrays.sort(ypos);

        int x4 = xpos[1] == xpos[0] ? xpos[2] : xpos[0];
        int y4 = ypos[1] == ypos[0] ? ypos[2] : ypos[0];

        sb.append(x4).append(" ").append(y4);

        bw.write(sb.toString());
        bw.flush();
    }
}
