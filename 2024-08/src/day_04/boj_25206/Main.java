package day_04.BOJ_S5_25206;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Map<String, Double> gradeMap = new HashMap<>();
        gradeMap.put("A+", 4.5);
        gradeMap.put("A0", 4.0);
        gradeMap.put("B+", 3.5);
        gradeMap.put("B0", 3.0);
        gradeMap.put("C+", 2.5);
        gradeMap.put("C0", 2.0);
        gradeMap.put("D+", 1.5);
        gradeMap.put("D0", 1.0);
        gradeMap.put("P", 5.0);
        gradeMap.put("F", 0.0);

        double sum1 = 0;
        double sum2 = 0;

        for(int i=0 ; i<20 ; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();

            double credit = Double.parseDouble(st.nextToken());
            double grade = gradeMap.get(st.nextToken());

            if(grade != 5.0){
                sum1 += credit * grade;
                sum2 += credit;
            }
        }

        System.out.println(sum2 > 0 ? sum1 / sum2 : 0);
    }
}
