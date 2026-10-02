package day_12.BOJ_G3_16235_Fail;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Node implements Comparable<Node> {
    int value;

    public Node(int value) {
        super();
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}

public class test {
    public static void main(String[] args) {

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1));
        q.offer(new Node(3));
        q.offer(new Node(5));
        q.offer(new Node(4));
        q.offer(new Node(2));

        while(!q.isEmpty()){
            System.out.print(q.poll().value + " ");
        }
        System.out.println();

        q.add(new Node(1));
        q.add(new Node(3));
        q.add(new Node(5));
        q.add(new Node(4));
        q.add(new Node(2));

        while(!q.isEmpty()){
            System.out.print(q.poll().value + " ");
        }
        System.out.println();

        Deque<Node> dq = new LinkedList<>();
        dq.offer(new Node(1));
        dq.offer(new Node(3));
        dq.offer(new Node(5));
        dq.offer(new Node(4));
        dq.offer(new Node(2));

        while(!dq.isEmpty()){
            System.out.print(dq.poll().value + " ");
        }
        System.out.println();

        dq.add(new Node(1));
        dq.add(new Node(3));
        dq.add(new Node(5));
        dq.add(new Node(4));
        dq.add(new Node(2));

        while(!dq.isEmpty()){
            System.out.print(dq.poll().value + " ");
        }
        System.out.println();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1));
        pq.offer(new Node(3));
        pq.offer(new Node(5));
        pq.offer(new Node(4));
        pq.offer(new Node(2));

        while(!pq.isEmpty()){
            System.out.print(pq.poll().value + " ");
        }
        System.out.println();

        pq.add(new Node(1));
        pq.add(new Node(3));
        pq.add(new Node(5));
        pq.add(new Node(4));
        pq.add(new Node(2));

        while(!pq.isEmpty()){
            System.out.print(pq.poll().value + " ");
        }
        System.out.println();

    }
}
