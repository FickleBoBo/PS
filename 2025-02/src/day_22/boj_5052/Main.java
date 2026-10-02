package day_22.BOJ_5052;

import java.io.*;
import java.util.*;

// 1시간

public class Main {

    private static class Trie {
        public static class TrieNode {
            char num;
            Map<Character, TrieNode> children;
            boolean isEnd = false;

            public TrieNode() {
                this.children = new HashMap<>();
            }

            public TrieNode(boolean isEnd) {
                this.isEnd = isEnd;
                this.children = new HashMap<>();
            }

            public TrieNode(char num) {
                this.num = num;
                this.children = new HashMap<>();
            }
        }

        TrieNode root = new TrieNode();

        public boolean insert(char[] input) {
            TrieNode node = root;
            boolean flag = false;
            boolean flag2 = false;

            for (int i = 0; i < input.length; i++) {
                if (node.isEnd) {
                    flag2 = true;
                }

                if (!node.children.containsKey(input[i])) {
                    if (i != input.length - 1) node.children.put(input[i], new TrieNode());
                    else node.children.put(input[i], new TrieNode(true));
                    flag = true;
                }

                node = node.children.get(input[i]);
            }

            if (flag2) return false;
            return flag;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            Trie trie = new Trie();

            boolean flag = true;

            for (int i = 0; i < N; i++) {
                boolean result = trie.insert(br.readLine().toCharArray());
                if (!result) {
                    flag = false;
                }
            }

            if (flag) bw.write("YES\n");
            else bw.write("NO\n");
        }

        bw.flush();
    }
}
