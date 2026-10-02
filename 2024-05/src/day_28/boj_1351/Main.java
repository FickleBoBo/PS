package day_28.BOJ_G5_1351;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static long P;
    static long Q;
    static Map<Long, Long> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        P = sc.nextLong();
        Q = sc.nextLong();
        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(calculateAN(N));
    }

    private static long calculateAN(long n) {
        if(map.containsKey(n)) return map.get(n);
        else{
            map.put(n, calculateAN(n/P) + calculateAN(n/Q));
        }
        return calculateAN(n/P) + calculateAN(n/Q);
    }
}
