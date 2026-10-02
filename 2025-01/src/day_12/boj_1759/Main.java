package day_12.BOJ_1759;

import java.io.*;
import java.util.*;

public class Main {

    private static final StringBuilder sb = new StringBuilder();
    private static final Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    private static char[] arr;
    private static char[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        sel = new char[L];

        combination(0, 0, 0, 0);

        bw.write(sb.toString());
        bw.flush();
    }

    private static void combination(int idx, int selIdx, int cntJa, int cntMo) {
        if (selIdx == sel.length) {
            if (cntJa < 2 || cntMo < 1) return;

            for (char c : sel) {
                sb.append(c);
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sel[selIdx] = arr[i];
            if (set.contains(arr[i])) {
                combination(i + 1, selIdx + 1, cntJa, cntMo + 1);
            } else {
                combination(i + 1, selIdx + 1, cntJa + 1, cntMo);
            }
        }
    }

}
