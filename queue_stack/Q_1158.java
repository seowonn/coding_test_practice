package coding_test_practice.queue_stack;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_1158 {
    static class Node{
        int data;
        Node next;
        Node prev;

        Node(){}
        Node(int data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    static class CirclyLinkedList{
        Node head;
        Node tail;

        CirclyLinkedList(){}
        public void addData(int data){
            if(this.head == null){
                this.head = new Node(data, null, null);
                this.tail = this.head;
            } else {
                this.tail.next = new Node(data, null, this.tail);
                this.tail = this.tail.next;
                this.tail.next = this.head;
            }
        }

        public int getLinkedListSize(){
            int size = 0;
            if(this.head == null) return size;
            Node cur = this.head;
            while(cur.next != null){
                size++;
                cur = cur.next;
            }
            return size;
        }

        public ArrayList<Integer> removeData(int order){
            ArrayList<Integer> list = new ArrayList<>();

            Node cur = this.head;
            Node prev = cur;
            while (this.head != null && this.tail != null){
                for (int i = 0; i < order-1; i++) {
                    prev = cur;
                    cur = cur.next;
                }

                list.add(cur.data);

                if(cur == this.head && cur == this.tail){
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) {
                    cur.next.prev = this.head.prev;
                    this.head = cur.next;
                    this.tail.next = this.head;
                } else if (cur == this.tail){
                    prev.next = this.tail.next;
                    this.tail = prev;
                    this.head.prev = this.tail;
                } else {
                    prev.next = cur.next;
                    cur.next.prev = prev;
                }
                prev = cur;
                cur = cur.next;
            }
            return list;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CirclyLinkedList linkedList = new CirclyLinkedList();

        int num = sc.nextInt(), order = sc.nextInt();
        for (int i = 1; i <= num; i++)
            linkedList.addData(i);

        ArrayList<Integer> list = linkedList.removeData(order);
        StringBuilder result = new StringBuilder("<");
        for (int i = 0; i < list.size() - 1; i++)
            result.append(list.get(i)).append(", ");
        result.append(list.get(list.size() - 1)).append(">");
        System.out.println(result);
    }
}
