package coding_test_practice;

import java.io.*;
import java.util.StringTokenizer;

public class Q_1890 {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 경로 개수 조건에 의해 long 타입으로 설정. 2^63 - 1
        long[][] dp = new long[N+1][N+1];

        dp[1][1] = 1;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int moveLength = Integer.parseInt(st.nextToken());

                if(dp[i][j] >= 1 && moveLength != 0) {
                    // 이동 가능한 경로마다 1씩 더해주게 되면, 최종 목적지에는 도달 가능한 경우의 수가 나오게 된다.
                    if(j + moveLength <= N) dp[i][j + moveLength] += dp[i][j];
                    if(i + moveLength <= N) dp[i + moveLength][j] += dp[i][j];
                }
            }
        }
        bw.write(dp[N][N] + "\n");
        bw.flush();
    }
}
