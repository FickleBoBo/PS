package day_12.BOJ_S4_1064;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        int[] B = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
        int[] C = { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };

        // ccw 알고리즘으로 한 직선 위에 있으면 만들 수 있는 평행사변형이 없다
        // 선분의 길이를 구해서 비교할 경우 부동소수점 오류로 반례 발생
        if(ccw(A, B, C) == 0){
            System.out.println(-1);
            return;
        }

        // 각 선분의 길이를 저장하고 정렬을 해준다
        // 둘레의 길이가 가장 큰 평행사변형은 길이가 긴 선분 2가지가 2개씩 필요
        // 둘레의 길이가 가장 짧은 평행사변형은 길이가 짧은 선분 2가지가 2개씩 필요
        double[] distArr = { dist(A, B), dist(B, C), dist(C, A) };
        Arrays.sort(distArr);

        double ans = (distArr[2] - distArr[0]) * 2;

        System.out.println(ans);
    }

    private static double dist(int[] pos1, int[] pos2){
        int dx = pos1[0] - pos2[0];
        int dy = pos1[1] - pos2[1];

        return Math.sqrt(dx*dx + dy*dy);
    }

    private static int ccw(int[] pos1, int[] pos2, int[] pos3){
        return (pos1[0] * pos2[1] - pos2[0] * pos1[1]) + (pos2[0] * pos3[1] - pos3[0] * pos2[1]) + (pos3[0] * pos1[1] - pos1[0] * pos3[1]);
    }
}
