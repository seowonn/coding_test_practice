package coding_test_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q_1254 {
    public static void main(String[] args) throws IOException{
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        if(S == null || S.isEmpty()) return;


        Deque<Character> deq = new ArrayDeque<>();
        for(char c : S.toCharArray()) deq.addLast(c);

        ArrayList<Character> result = new ArrayList<>();
        while (deq.size() > 1) {
            char a = deq.pollFirst();
            char b = deq.pollLast();

            if(a == b) {
                result.add(a);
                result.add(b);
            } else {
                result.add(a);
                result.add(a);
                deq.addLast(b);
            }
        }
        answer = deq.isEmpty() ? result.size() : result.size() + deq.size();
        System.out.println(answer);
    }
}
