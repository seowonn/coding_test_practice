package coding_test_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        ArrayList<String> strs = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            strs.add(br.readLine());
        }

        String leftWord = "(";
        String rightWord = ")";

        for (int i = 0; i < strs.size(); i++) {
            String str = strs.get(i);
            int remain = 0;
            Queue<String> queue = new LinkedList<>();
            for(String s : str.split("")){
                if(queue.isEmpty()){
                    if(s.equals(leftWord)) {
                        queue.add(s);
                    } else {
                        remain++;
                    }
                } else{
                    if(s.equals(rightWord)){
                        queue.poll();
                    } else {
                        queue.add(s);
                    }
                }
            }
            if(queue.isEmpty() && remain == 0) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }
}
