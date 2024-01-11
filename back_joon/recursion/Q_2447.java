package coding_test_practice.back_joon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    반복되는 특징을 어떻게 재귀호출로 구현할 수 있는지를 생각해봐야 했던 문제.
    특징은 공백 구간의 특징을 찾고, 공백구간이 아닌 구간에 대해서는 재귀호출을 진행하면 된다는 점.!
    공백 구간은 항상 5번째 칸이란 걸 특징할 수 있어야 한다..
 */

public class Q_2447 {

    static char arr[][];

    public static void printStar(int x, int y, int n, boolean blank) {
        if(blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더 이상 쪼개지지 않을 때 : 탈출 조건
        if(n == 1) {
            arr[x][y] = '*';
            return;
        }

        // 패턴이 3으로 나눠진다면 계속해서 3씩 쪼개지면서 반복되고 있다.
        // 즉 3으로 계속 쪼개면서 1이 될때까지 반복하는 것이다.
        int size = n / 3;
        int count = 0; // 5번째 구간에서는 공백을 넣기 위한 용도이다.
        // n * n 배열을 순회하는 for문을 작성하되, 3으로 나눠진 구간에 대한 반복으로,
        // 간격을 size로 둔다.
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                count++;
                if(count == 5) printStar(i, j, size, true);
                else printStar(i, j, size, false);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        printStar(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
