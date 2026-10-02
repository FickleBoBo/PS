package day_12.BOJ_G3_17386;

import java.io.*;
import java.util.StringTokenizer;

// ccw 알고리즘 몰라도 아마 구현으로 되는데 int형 나눗셈은 버림처리 되는거랑 double로 해도 부동소수점 오류때문에 쉽지 않을듯?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // L1의 양 끝점 입력 받기
        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        // L2의 양 끝점 입력 받기
        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        int ans = ccw(x1, y1, x2, y2, x3, y3, x4, y4);
        System.out.println(ans);
    }

    // ccw 알고리즘(모르면 당하는 유형)
    // 두 선분의 관계를 벡터의 외적으로 알아낼 수 있음
    // 두 선분이 교차(세 점이 일직선 위에 있지 않음, 있어도 잘 풀면 되긴함)하는 경우, 한 선분을 연장한 직선에 대해 나머지 선분의 두 점이 직선의 서로 반대편에 위치함
    // 그러면 직선과 두 점에 대한 외적 벡터가 서로 정반대 방향을 가리킴(벡터의 부호가 반대)
    // 각 선분에 대해 둘 다 외적 벡터의 방향이 반대면 두 선분이 교차하는 상태
    // 좌표로 주어진 벡터의 외적은 신발끈 공식으로 구할 수 있음
    private static int ccw(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){

        // 벡터 (x1, y1), (x2, y2)와 벡터 (x1, y1), (x3, y3)의 외적
        int vector1 = (x2 * y3 - x3 * y2) + (x3 * y1 - x1 * y3) + (x1 * y2 - x2 * y1) > 0 ? 1 : -1;
        // 벡터 (x1, y1), (x2, y2)와 벡터 (x1, y1), (x4, y4)의 외적
        int vector2 = (x2 * y4 - x4 * y2) + (x4 * y1 - x1 * y4) + (x1 * y2 - x2 * y1) > 0 ? 1 : -1;
        // 벡터 (x3, y3), (x4, y4)와 벡터 (x3, y3), (x1, y1)의 외적
        int vector3 = (x4 * y1 - x1 * y4) + (x1 * y3 - x3 * y1) + (x3 * y4 - x4 * y3) > 0 ? 1 : -1;
        // 벡터 (x3, y3), (x4, y4)와 벡터 (x3, y3), (x2, y2)의 외적
        int vector4 = (x4 * y2 - x2 * y4) + (x2 * y3 - x3 * y2) + (x3 * y4 - x4 * y3) > 0 ? 1 : -1;

        // 각각의 외적 벡터의 곱이 모두 음수면 선분이 교차 상태
        // 외적 벡터의 부호만 알면 되는데 크기를 그대로 쓰면 long이어도 오버플로우 발생해서 부호만 뽑아냄(테스트 케이스 2%)
        return (vector1 * vector2 < 0) && (vector3 * vector4 < 0) ? 1 : 0;
    }

}
