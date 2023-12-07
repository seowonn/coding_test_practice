package coding_test_practice.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    1, 2, 3의 합으로 나타낼 수 있는 가짓수를 구하는 문제..
    이전 값들을 가지고 현재 값을 구할 수 있는 연관성이 존재한다면(bottim - up) 해당 규칙을 파악해서
    dynamic programming 방법을 적용한다.
 */

public class Q_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[11];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            for (int j = 4; j <= 10; j++) {
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            result.add(dp[n]);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(result.get(i));
        }
    }
}
