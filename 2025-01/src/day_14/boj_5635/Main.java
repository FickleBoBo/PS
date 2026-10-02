package day_14.BOJ_5635;

import java.io.*;
import java.util.*;

public class Main {

    private static class Student implements Comparable<Student> {
        String name;
        int day;
        int month;
        int year;

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Student o) {
            if (this.year != o.year) return Integer.compare(this.year, o.year);
            if (this.month != o.month) return Integer.compare(this.month, o.month);
            return Integer.compare(this.day, o.day);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            students[i] = new Student(name, day, month, year);
        }
        Arrays.sort(students);

        sb.append(students[N - 1].name).append("\n").append(students[0].name);

        bw.write(sb.toString());
        bw.flush();
    }
}
