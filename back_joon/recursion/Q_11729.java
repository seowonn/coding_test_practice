package coding_test_practice.back_joon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    풀이 방법 : 재귀
    하노이 탑 3개를 가지고 이동 과정을 그려보니, 우선적으로 가장 큰 마지막 판을 제외한 나머지 n - 1개으 판을
    중간 지점에 다 옮기고, 가장 마지막 판을 목적지에 옮겨야 하는 큰 틀을 발견했다.
    위의 과정이 조금 추상적이라고 생각해서 코드로 어떻게 구체화해야 하나 막막했는데.. 음 우선 탈출 코드와
    해당 과정을 재귀로 작성하면 동작한다.
    즉 명확한 규칙과 탈출 조건 정의가 되어 있다면 문제를 잘 푼 것이라고 생각한다..!
 */

public class Q_11729 {

    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void hanoi(int n, int from, int mid, int to) {
        if(n == 0){
            return;
        }
        hanoi(n - 1, from, to, mid);
        sb.append(from + " " + to + "\n");
        cnt++;
        hanoi(n - 1, mid, from, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 2, 3);

        System.out.println(cnt);
        System.out.println(sb);
    }
}
