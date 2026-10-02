package day_22.monthly_d;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        out:
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Deque<Integer> stack = new ArrayDeque<>();
            for (int x : arr) {
                if (x == 1 || (!stack.isEmpty() && (stack.peek() + 1 == x))) {
                    stack.push(x);
                } else {
                    if (stack.isEmpty()) {
                        bw.write("NO\n");
                        continue out;
                    } else {
                        while (!stack.isEmpty() && stack.peek() != 1) {
                            stack.pop();
                        }
                        stack.pop();

                        if (stack.isEmpty() || stack.peek() + 1 != x) {
                            bw.write("NO\n");
                            continue out;
                        } else {
                            stack.push(x);
                        }
                    }
                }

                System.out.println(stack);
            }

            bw.write("YES\n");
        }

        bw.flush();
    }
}
// 1
// 2
// 3
//   1
//   2
//     1
//       1
//       2
//     2
//       1

// 1
// 2
//   1
//   2

// 1
// 2
//   1
//   2
// 3

// 1
//.  1
//.    1
//.      1
//.      2
//.    2
//.  2
//.2
