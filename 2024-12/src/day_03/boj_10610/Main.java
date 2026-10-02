package day_03.BOJ_10610;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        int[] nums = new int[input.length()];
        boolean hasZero = false;
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            if (num == 0) {
                hasZero = true;
            }

            nums[i] = num;
            sum += num;
        }

        if (hasZero && (sum % 3 == 0)) {
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 0; i--) {
                sb.append(nums[i]);
            }
        } else {
            sb.append(-1);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
