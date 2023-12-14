package coding_test_practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1991 {
    static Node[] nodes;
    static int N;

    static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        nodes = new Node[26];
        for (int i = 0; i < N; i++) {
            char c = (char)('A' + i);
            nodes[c - 'A'] = new Node(c, null, null);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String node = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            if(!left.equals(".") && nodes[node.charAt(0) - 'A'].left == null)
                nodes[node.charAt(0) - 'A'].left = nodes[left.charAt(0) - 'A'];
            if(!right.equals(".") && nodes[node.charAt(0) - 'A'].right == null)
                nodes[node.charAt(0) - 'A'].right = nodes[right.charAt(0) - 'A'];
        }
        preOrder(nodes[0]);
        System.out.println();
        inOrder(nodes[0]);
        System.out.println();
        postOrder(nodes[0]);
    }

    public static void preOrder(Node node) {
        if(node == null) return;

        System.out.print(node.data);
        if(node.left != null)
            preOrder(node.left);
        if(node.right != null)
            preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node == null) return;

        if(node.left != null) {
            inOrder(node.left);
        }
        System.out.print(node.data);
        if(node.right != null) {
            inOrder(node.right);
        }
    }

    public static void postOrder(Node node) {
        if(node == null) return;

        if(node.left != null) {
            postOrder(node.left);
        }
        if(node.right != null) {
            postOrder(node.right);
        }
        System.out.print(node.data);
    }
}
