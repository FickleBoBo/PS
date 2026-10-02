package day_11.BOJ_2504;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<String> stack = new ArrayDeque<>();

        char[] input = br.readLine().toCharArray();

        boolean flag = true;

        for (char c : input) {
            if (c == '(') stack.push("(");
            else if (c == '[') stack.push("[");
            else {
                if (stack.isEmpty()) {
                    flag = false;
                    break;
                } else {
                    String pop = stack.pop();
                    if (c == ')') {
                        if (pop.equals("(")) stack.push("2");
                        else if (pop.equals("[")) {
                            flag = false;
                            break;
                        } else {
                            if (stack.isEmpty()) {
                                flag = false;
                                break;
                            }

                            String pop2 = stack.pop();
                            if (pop2.equals("(")) stack.push(mul(pop, 2));
                            else if (pop2.equals("[")) {
                                flag = false;
                                break;
                            } else stack.push(sum(pop, pop2));
                        }
                    } else if (c == ']') {
                        if (pop.equals("[")) stack.push("3");
                        else if (pop.equals("(")) {
                            flag = false;
                            break;
                        } else {
                            if (stack.isEmpty()) {
                                flag = false;
                                break;
                            }

                            String pop2 = stack.pop();
                            if (pop2.equals("[")) stack.push(mul(pop, 3));
                            else if (pop2.equals("(")) {
                                flag = false;
                                break;
                            } else stack.push(sum(pop, pop2));
                        }
                    }
                }
            }

            while (stack.size() >= 2) {
                String pop1 = stack.pop();
                String pop2 = stack.pop();

                if (!(pop1.equals("(") || pop1.equals("[")) && !(pop2.equals("(") || pop2.equals("["))) {
                    stack.push(sum(pop1, pop2));
                } else {
                    stack.push(pop2);
                    stack.push(pop1);
                    break;
                }
            }
        }

        if (stack.size() != 1 || (stack.peek().equals("(") || stack.peek().equals("["))) flag = false;

        if (flag) System.out.println(stack.pop());
        else System.out.println(0);
    }

    private static String sum(String num1, String num2) {
        return Integer.toString(Integer.parseInt(num1) + Integer.parseInt(num2));
    }

    private static String mul(String num1, int num2) {
        return Integer.toString(Integer.parseInt(num1) * num2);
    }

}
