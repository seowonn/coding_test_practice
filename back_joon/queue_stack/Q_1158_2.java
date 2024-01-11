package coding_test_practice.back_joon.queue_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_1158_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Character[] ch = new Character[2];

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();
        String[] s = new String[5];
        result.add("aaaa");
        System.out.println(result);

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        int cnt = 1;
        while(!queue.isEmpty()){
            if(cnt % K == 0){
                result.add(queue.poll().toString());
            } else {
                queue.add(queue.poll());
            }
            cnt++;
        }
        System.out.print("<");
        String string = String.join(", ", result);
        System.out.print(string);
        System.out.print(">");
    }
}
