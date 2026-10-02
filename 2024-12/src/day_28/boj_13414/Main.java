package day_28.BOJ_13414;

import java.io.*;
import java.util.*;

public class Main {

    static class Student implements Comparable<Student> {
        String id;
        int order;

        public Student(String id, int order) {
            this.id = id;
            this.order = order;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(this.order, o.order);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Map<String, Student> map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String id = br.readLine();

            map.put(id, new Student(id, i));
        }

        PriorityQueue<Student> pq = new PriorityQueue<>(map.values());

        int cnt = 0;
        while (!pq.isEmpty()) {
            sb.append(pq.poll().id).append("\n");
            cnt++;

            if (cnt == K) break;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
