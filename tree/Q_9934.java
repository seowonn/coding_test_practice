package coding_test_practice.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_9934 {
    static int K;
    static int[] binaryTree;
    static HashMap<Integer, ArrayList<Integer>> result = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // 깊이 K는 높이 + 1의 수로, 1부터 센다.
        // 깊이 K일 때 완전 이진 트리의 노드 수는 2^K - 1개 이다.
        // 중위 순회 방식
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        for (int i = 1; i <= K; i++) {
            result.putIfAbsent(i, new ArrayList<>());
        }
        binaryTree = new int[(int)Math.pow(2, K) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Math.pow(2, K) - 1; i++) {
            binaryTree[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = binaryTree.length - 1;
        int depth = 1;

        divide(depth, left, right);
        for (int i = 1; i <= K; i++) {
            ArrayList<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++)
                System.out.print(list.get(j) + " ");
            System.out.println();
        }
    }

    public static void divide(int depth, int left, int right) {

        if(depth > K) return;

        int mid = left + (right - left) / 2;
        result.get(depth).add(binaryTree[mid]);

        divide(depth + 1, left, mid - 1);
        divide(depth + 1, mid + 1, right);
    }

}
