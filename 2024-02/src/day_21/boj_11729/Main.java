package day_21.BOJ_G5_11729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();    // 억까 문제라 StringBuilder 써야 됨

    static void Hanoi(int N, int from, int tmp, int to){
        if(N==1){
            sb.append(from);
            sb.append(" ");
            sb.append(to);
            sb.append("\n");
            return;
        }
        Hanoi(N-1, from, to, tmp);
        sb.append(from);
        sb.append(" ");
        sb.append(to);
        sb.append("\n");
        Hanoi(N-1, tmp, from, to);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = (int) Math.pow(2, N) - 1;    // 그냥 점화식으로 이동 횟수 구하기

        System.out.println(cnt);
        Hanoi(N, 1, 2, 3);

        System.out.println(sb.toString());    // 반복문 돌거면 sb 사용하는 의미 없는 듯
        br.close();
    }
}
