package coding_test_practice.two_pointer;

import java.io.*;
import java.util.*;

public class Q_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        int p1 = 0, p2 = 0;
        StringBuilder result = new StringBuilder();
        while(p1 < N && p2 < M) {
            if(A[p1] <= B[p2]) {
                result.append(A[p1++] + " ");
            } else {
                result.append(B[p2++] + " ");
            }
        }

        if(p1 == N) {
            for (int i = p2; i < M; i++) {
                result.append(B[i] + " ");
            }
        } else if (p2 == M) {
            for (int i = p1; i < N; i++) {
                result.append(A[i] + " ");
            }
        }
        System.out.print(result);
    }
}
