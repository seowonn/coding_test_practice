package coding_test_practice.back_joon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// idea : sunstring을 이용해, 해당 인덱스 기준 그 이후 모든 글자가 palindrome인지 판별

public class Q_1254 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        if(S == null || S.isEmpty()) return;

        int idx = S.length() - 1;
        for (int i = 0; i < idx; i++) {
            if(isPalindrome(S.substring(i))) {
                idx = i;
                break;
            }
        }
        System.out.println(S.length() + idx);
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
