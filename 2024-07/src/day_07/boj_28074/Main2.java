package day_07.BOJ_B4_28074;

import java.io.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        if(input.contains("M") && input.contains("O") && input.contains("B") && input.contains("I") && input.contains("S")){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
