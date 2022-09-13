package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B25501 {   // Palindrome (재귀)

    static int count;   // recursion 함수의 호출 횟수

    public static int recursion(String s, int l, int r){
        /**
         * 팰린드롬이면 1, 팰린드롬이 아니면 0
         */

        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    /**
     * T -> 테스트케이스의 개수
     * S -> 알파벳 대문자로 이루어진 문자열
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){ // T -> 테스트케이스의 개수
            count = 0;
            System.out.println(isPalindrome(br.readLine())+" "+count);
        }
    }

}
