package day_05.BOJ_25381;

import java.io.*;

public class Main {

    private static char[] S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine().toCharArray();

        int ans = 0;

        ans += delete('B', 'C');
        ans += delete('A', 'B');

        System.out.println(ans);
    }

    private static int delete(char c1, char c2) {
        int left = 0;
        int right = left + 1;
        int cnt = 0;

        while (true) {
            while (left < S.length && S[left] != c1) {
                left++;
            }
            while (right < S.length && (S[right] != c2 || left > right)) {
                right++;
            }

            if (right == S.length) {
                break;
            }

            S[left] = ' ';
            S[right] = ' ';
            cnt++;
        }

        return cnt;
    }

}
