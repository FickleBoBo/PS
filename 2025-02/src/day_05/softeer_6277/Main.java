package day_05.Softeer_6277;

import java.io.*;
import java.util.*;

public class Main {

    // 위치의 최댓값
    private static final int INF = 1000;

    private static int K;
    private static int min = Integer.MAX_VALUE;
    private static List<int[]>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new ArrayList[1 + K];
        for (int i = 1; i <= K; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr[k].add(new int[]{r, c});
        }

        combination(1, 0, INF, INF, -INF, -INF, (2 * INF) * (2 * INF));

        System.out.println(min);
    }

    private static void combination(int idx, int selIdx, int minX, int minY, int maxX, int maxY, int area) {
        // 점을 더 선택해도 min보다 작아질 수 없으므로 종료하는 백트래킹
        if (area >= min) return;

        // K개의 점을 선택하면 min 갱신
        if (selIdx == K) {
            min = area;
            return;
        }

        // 현재 그룹의 모든 점들을 한번씩 선택
        for (int[] next : arr[idx]) {
            int newMinX = Math.min(minX, next[0]);
            int newMinY = Math.min(minY, next[1]);
            int newMaxX = Math.max(maxX, next[0]);
            int newMaxY = Math.max(maxY, next[1]);

            // 다음 그룹에서 다음 점을 선택
            combination(idx + 1, selIdx + 1, newMinX, newMinY, newMaxX, newMaxY, (newMaxX - newMinX) * (newMaxY - newMinY));
        }
    }

}
