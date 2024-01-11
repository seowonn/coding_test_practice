package coding_test_practice.back_joon.dynamic_programming;

import java.io.*;
import java.util.StringTokenizer;

public class Q_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] totalDp = new int[n + 1];


             st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++)
            totalDp[i] = totalDp[i - 1] + Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            bw.write(totalDp[p2] - totalDp[p1 - 1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
