package day_14.BOJ_10814;

import java.io.*;
import java.util.*;

public class Main {

    static class Member implements Comparable<Member> {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if (this.age != o.age) return Integer.compare(this.age, o.age);
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        List<Member> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            list.add(new Member(age, name));
        }
        Collections.sort(list);

        for (Member member : list) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
