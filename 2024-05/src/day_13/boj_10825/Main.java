package day_13.BOJ_S4_10825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][4];
        for(int i=0 ; i<N ; i++){
            arr[i] = br.readLine().split(" ");
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(Integer.parseInt(o1[1]) == Integer.parseInt(o2[1])){
                if(Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])){
                    if(Integer.parseInt(o1[3]) == Integer.parseInt(o2[3])){
                        return o1[0].compareTo(o2[0]);
                    }
                    return -(Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]));
                }
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            }
            return -(Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]));
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0 ; i<N ; i++){
            sb.append(arr[i][0] + "\n");
        }

        System.out.println(sb.toString());
    }
}
