package day_11.BOJ_S4_10816_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();

        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()){
            int ans = 0;
            int num = Integer.parseInt(st.nextToken());
            while(list.contains(num)){
                list.remove((Integer) num);
                ans++;
            }
            System.out.printf(ans + " ");
        }

        br.close();
    }
}
