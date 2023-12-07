package coding_test_practice.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    대표적인 DP 문제.
    Bottom - up 방식으로 풀이.
    입력값 크기 + 1 만큼의 DP메모리를 만들고, 1을 0으로 설정, 2부터 시작하여 이전 구한 값을 가지고
    지정값까지 더 작은 횟수로 채워 나가는 방법.!
 */

public class Q_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];

        for (int i = 2; i <= X; i++) {
            dp[i] = dp[i - 1] + 1;

            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[X]);
    }
}
