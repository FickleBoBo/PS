package day_28.BOJ_S3_2910;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Node implements Comparable<Node> {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.cnt, this.cnt);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int C = sc.nextInt();

        List<Node> nums = new ArrayList<>();

        out:
        for(int i=0 ; i<N ; i++){
            int n = sc.nextInt();
            for(int j=0 ; j<nums.size() ; j++){
                if(nums.get(j).num == n){
                    nums.get(j).cnt++;
                    continue out;
                }
            }
            nums.add(new Node(n, 0));
        }
        Collections.sort(nums);

        for(Node node : nums){
            for(int i=0 ; i<=node.cnt ; i++){
                System.out.print(node.num + " ");
            }
        }

    }
}
