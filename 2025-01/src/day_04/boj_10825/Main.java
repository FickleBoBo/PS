package day_04.BOJ_10825;

import java.io.*;
import java.util.*;

public class Main {

    private static class Student implements Comparable<Student> {
        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Student o) {
            if (this.kor != o.kor) return Integer.compare(o.kor, this.kor);
            if (this.eng != o.eng) return Integer.compare(this.eng, o.eng);
            if (this.math != o.math) return Integer.compare(o.math, this.math);
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            students.add(new Student(name, kor, eng, math));
        }

        Collections.sort(students);

        for (Student student : students) {
            sb.append(student.name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
