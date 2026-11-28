package day_22.boj_10814;

import java.io.*;
import java.util.*;

public class Main {

    static class User {
        int age;
        String name;

        User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        User[] users = new User[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            users[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(users, (o1, o2) -> Integer.compare(o1.age, o2.age));

        for (User user : users) {
            sb.append(user.age).append(" ").append(user.name).append("\n");
        }

        System.out.println(sb);
    }
}
