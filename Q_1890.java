package coding_test_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1890 {
    static int[][] dirs = {{0, 1}, {1, 0}};
    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        cnt += dfs(board, 0, 0, 0);
        System.out.println(cnt);
    }

    public static int dfs(int[][] board, int i, int j, int cnt) {
        int move = board[i][j];
        for(int[] dir : dirs) {
            int xNext = i + dir[0] * move;
            int yNext = j + dir[1] * move;

            if(xNext < 0 || xNext >= board.length || yNext < 0 || yNext >= board.length) return 0;
            if(board[xNext][yNext] == 0) {
                cnt++;
                return cnt;
            }
            cnt += dfs(board, xNext, yNext, 0);
        }
        return cnt;
    }
}
