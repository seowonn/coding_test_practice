package coding_test_practice.back_joon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2630 {
    static int[][] colorPaper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        colorPaper = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                colorPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dividePaper(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void dividePaper(int startX, int startY, int n) {
        if(colorCheck(startX, startY, n)) {
            if(colorPaper[startX][startY] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        dividePaper(startX, startY, n / 2);
        dividePaper(startX + n / 2, startY,n / 2);
        dividePaper(startX, startY + n / 2, n / 2);
        dividePaper(startX + n / 2, startY + n / 2,  n / 2);
    }

    // 분할된 종이의 색깔이 같은지 검사한다.
    public static boolean colorCheck(int startX, int startY, int n) {
        int color = colorPaper[startX][startY];

        for (int i = startX; i < startX + n; i++) {
            for (int j = startY; j < startY + n; j++) {
                if(colorPaper[i][j] != color) return false;
            }
        }
        return true;
    }
}
