package day_27.BOJ_S3_9375;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for(int tc=1 ; tc<=T ; tc++){
            Map<String, Integer> map = new HashMap<>();

            int M = Integer.parseInt(sc.nextLine());
            for(int i=0 ; i<M ; i++){
                String[] input = sc.nextLine().split(" ");
                map.put(input[1], map.getOrDefault(input[1], 0) + 1);
            }

            int ans = 1;
            for(String key : map.keySet()){
                ans *= (map.get(key) + 1);
            }

            System.out.println(ans - 1);
        }
    }
}
