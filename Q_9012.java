package coding_test_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] strings = new String[T];
        for (int i = 0; i < T; i++) {
            strings[i] = br.readLine();
        }

        for (int i = 0; i < T; i++) {
            boolean flag = true;
            String string = strings[i];
            Stack<Character> stack = new Stack<>();
            for(char c : string.toCharArray()){
                if(c == '('){
                    stack.push(c);
                } else {
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty() && flag)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
