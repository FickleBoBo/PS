package day_26.BOJ_S5_10814;

import java.io.*;
import java.util.*;

public class Main {

    static class Person implements Comparable<Person>{
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        // 정렬 기준을 나이순으로 설정
        // 입력 순서가 가입일 순서여서 고려할 필요 없음
        @Override
        public int compareTo(Person o) {
            return Integer.compare(this.age, o.age);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Person[] pArr = new Person[N];
        for(int i=0 ; i<N ; i++) {
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            pArr[i] = new Person(age, name);
        }

        Arrays.sort(pArr);

        for(int i=0 ; i<N ; i++){
            sb.append(pArr[i].age).append(" ").append(pArr[i].name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
