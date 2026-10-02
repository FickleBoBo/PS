package day_14.BOJ_G5_11758;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        int ans = ccw(x1, y1, x2, y2, x3, y3);
        System.out.println(ans);
    }

    // ccw 알고리즘
    // 벡터 (x1, y1) -> (x2, y2) 와 벡터 (x1, y1) -> (x3, y3)의 외적
    private static int ccw(int x1, int y1, int x2, int y2, int x3, int y3){
        int vector = (x2 * y3 - x3 * y2) + (x3 * y1 - x1 * y3) + (x1 * y2 - x2 * y1);

        if(vector > 0) return 1;
        if(vector < 0) return -1;
        return 0;
    }

}
