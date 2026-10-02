package day_18.BOJ_2257;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> stack = new ArrayDeque<>();

        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            if (c == ')') {
                int sum = 0;
                while (true) {
                    String item = stack.pop();
                    if (item.equals("(")) {
                        stack.push(Integer.toString(sum));
                        break;
                    }

                    sum += Integer.parseInt(item);
                }
            } else if ('1' <= c && c <= '9') {
                stack.push(Integer.toString(Integer.parseInt(stack.pop()) * Character.getNumericValue(c)));
            } else {
                if (c == 'H') {
                    stack.push(Integer.toString(1));
                } else if (c == 'C') {
                    stack.push(Integer.toString(12));
                } else if (c == 'O') {
                    stack.push(Integer.toString(16));
                } else {
                    stack.push(Character.toString(c));
                }
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += Integer.parseInt(stack.pop());
        }

        System.out.println(sum);
    }
}
