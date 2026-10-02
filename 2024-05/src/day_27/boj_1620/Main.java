package day_27.BOJ_S4_1620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        Map<String, String> map = new HashMap<>();

        for(int i=1 ; i<=N ; i++){
            String input = sc.next();
            map.put(input, i+"");
            map.put(i+"", input);
        }

        sc.nextLine();

        for(int i=0 ; i<M ; i++){
            String input = sc.nextLine();
            System.out.println(map.get(input));
        }
    }
}
