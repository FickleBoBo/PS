package day_12.BOJ_16463;

import java.io.*;

public class Main {

    // 윤년
    private static final int[] monArr = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    // 윤년이 아닌 년
    private static final int[] monArr2 = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final int SUN = 0;
    private static final int TUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int week = TUE;
        int cnt = 0;
        for (int year = 2019; year <= N; year++) {
            int[] arr = (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0) ? monArr : monArr2;

            for (int mon = 1; mon <= 12; mon++) {
                if (week == SUN) cnt++;

                week += arr[mon];
                week %= 7;
            }
        }

        System.out.println(cnt);
    }
}
