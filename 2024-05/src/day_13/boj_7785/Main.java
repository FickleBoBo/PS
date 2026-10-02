package day_13.BOJ_S5_7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        for(int i=0 ; i<n ; i++){
            String[] input = br.readLine().split(" ");
            if(input[1].equals("enter")){
                map.put(input[0], input[1]);
            }
            else{
                if(map.getOrDefault(input[0], null) != null){
                    map.remove(input[0]);
                }
            }
        }

        String[] left = new String[map.size()];
        int idx = 0;
        for(String key : map.keySet()){
            left[idx++] = key;
        }

        Arrays.sort(left);

        for(int i=left.length-1 ; i>=0 ; i--){
            System.out.println(left[i]);
        }
    }
}
