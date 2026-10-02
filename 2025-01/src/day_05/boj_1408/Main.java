package day_05.BOJ_1408;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int time1 = getTime(br.readLine());
        int time2 = getTime(br.readLine());

        int time = time2 > time1 ? time2 - time1 : time2 - time1 + 86400;
        int h3 = time / 3600;
        int m3 = time % 3600 / 60;
        int s3 = time % 60;

        if (h3 < 10) sb.append("0");
        sb.append(h3).append(":");

        if (m3 < 10) sb.append("0");
        sb.append(m3).append(":");

        if (s3 < 10) sb.append("0");
        sb.append(s3);

        bw.write(sb.toString());
        bw.flush();
    }

    private static int getTime(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        return h * 3600 + m * 60 + s;
    }

}
