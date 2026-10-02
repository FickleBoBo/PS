package day_10.BOJ_S5_1181;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<String> list = new ArrayList<>();

        for(int i=0 ; i<N ; i++){
            String input = sc.next();
            if(!list.contains(input)){
                list.add(input);
            }
        }

        String[] arr = new String[list.size()];
        for (int i=0 ; i<list.size() ; i++) {
            arr[i] = list.get(i);
        }

        Arrays.sort(arr);
        int len = 1;
        int n = arr.length;
        while(n > 0){
            for(int i=0 ; i<arr.length ; i++){
                if(arr[i].length() == len){
                    System.out.println(arr[i]);
                    n--;
                }
            }
            len++;
        }

        sc.close();
    }
}
