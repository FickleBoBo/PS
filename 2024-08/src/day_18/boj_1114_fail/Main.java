package day_18.BOJ_G1_1114_Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int idx;
        int pos;
        int len;

        public Node(int idx, int pos, int len) {
            this.idx = idx;
            this.pos = pos;
            this.len = len;
        }

        @Override
        public int compareTo(Node o) {
            if(this.len == o.len) return Integer.compare(o.pos, this.pos);
            return Integer.compare(this.len, o.len);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "pos=" + pos +
                    ", len=" + len +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Set<Integer> set = new TreeSet<>();
        while(st.hasMoreTokens()){
            set.add(Integer.parseInt(st.nextToken()));
        }
        set.add(0);
        set.add(L);

        List<Integer> list = new ArrayList<>(set);
//        System.out.println(list);

        PriorityQueue<Node> pq;
        while(list.size() > C + 2){
            pq = new PriorityQueue<>();
            for(int i=0 ; i<list.size()-2 ; i++){
                Node newNode = new Node(i+1, list.get(i+2), list.get(i+2) - list.get(i));
                pq.offer(newNode);
//                System.out.println(newNode);
//                System.out.println();
            }
            Node node = pq.poll();
            list.remove(node.idx);
        }

        int ans1 = 0;
        int ans2 = Integer.MAX_VALUE;

//        System.out.println(list);

        for(int i=0 ; i<list.size()-1 ; i++){
            ans1 = Math.max(list.get(i+1) - list.get(i), ans1);
            if(list.get(i) > 0){
                ans2 = Math.min(ans2, list.get(i));
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
