package day_11.BOJ_4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            String input = br.readLine();
            if (input.equals(".")) break;

            Deque<String> stack = new ArrayDeque<>();
            st = new StringTokenizer(input, "()[]", true);
            boolean flag = true;

            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (!(token.equals("(") || token.equals(")") || token.equals("[") || token.equals("]"))) continue;

                if (token.equals("(") || token.equals("[")) stack.push(token);
                else {
                    if (stack.isEmpty()) {
                        flag = false;
                        break;
                    } else {
                        String pop = stack.pop();

                        if (pop.equals("(")) {
                            if (token.equals("]")) {
                                flag = false;
                                break;
                            }
                        } else {
                            if (token.equals(")")) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
            }

            if (!stack.isEmpty()) flag = false;

            if (flag) bw.write("yes\n");
            else bw.write("no\n");
        }

        bw.flush();
    }
}
