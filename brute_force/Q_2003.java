package coding_test_practice.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int endPoint = 0, startPoint = 0, sum = 0;
        while (true) {
            // 범위를 넘어가는 경우에 대한 처리가 더 우선. 왜냐 하면 sum이 M값에 도달한 후에 대한 처리를 해줘야 하기 떄문!
            if(sum >= M) {
                sum -= A[startPoint++];
            } else if (endPoint >= N) {
                break;
            } else {
                sum += A[endPoint++];
            }

            if(sum == M) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
