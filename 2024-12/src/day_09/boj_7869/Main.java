package day_09.BOJ_7869;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double r2 = Double.parseDouble(st.nextToken());

        // 두 원의 중심 사이 거리
        double d = distance(x1, y1, x2, y2);

        // 두 원의 반지름의 합보다 중심 사이 거리가 멀면 교차하는 영역이 없음
        if (d >= r1 + r2) {
            System.out.println("0.000");  // String으로 출력안하면 0.0으로 출력됨
            return;
        // 한 원이 다른 원 내부에 있는 경우
        } else if (d <= r1 - r2) {
            System.out.printf("%.3f", areaOfCircle(r2));
            return;
        } else if (d <= r2 - r1) {
            System.out.printf("%.3f", areaOfCircle(r1));
            return;
        }

        double sector1 = areaOfSector(r1, 2 * angle(r1, d, r2));
        double triangle1 = areaOfTriangle(r1, r1, 2 * angle(r1, d, r2));
        double sector2 = areaOfSector(r2, 2 * angle(r2, d, r1));
        double triangle2 = areaOfTriangle(r2, r2, 2 * angle(r2, d, r1));

        // 부채꼴 넓이에서 삼각형 넓이를 뺀 현의 넓이로 교차하는 영역의 넓이를 구함
        System.out.printf("%.3f", sector1 - triangle1 + sector2 - triangle2);
    }

    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // 제2코사인법칙 응용
    private static double angle(double a, double b, double c) {
        return Math.acos((a * a + b * b - c * c) / (2 * a * b));
    }

    // 원의 넓이를 구하는 메서드
    private static double areaOfCircle(double radius) {
        return Math.PI * radius * radius;
    }

    // 부채꼴의 넓이를 구하는 메서드
    private static double areaOfSector(double radius, double angle) {
        return Math.PI * radius * radius * (angle / (2 * Math.PI));
    }

    // 삼각형의 넓이를 구하는 메서드
    private static double areaOfTriangle(double a, double b, double angle) {
        return 0.5 * a * b * Math.sin(angle);
    }

}
