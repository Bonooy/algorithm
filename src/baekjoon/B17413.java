package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        String S = br.readLine();
        boolean tag = false;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '<') {
                tag = true;
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(S.charAt(i));
            } else if (S.charAt(i) == '>') {
                tag = false;
                sb.append(S.charAt(i));
            } else if (tag == true) {
                sb.append(S.charAt(i));
            } else if (tag == false) {
                if (S.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(S.charAt(i));
                } else {
                    stack.push(S.charAt(i));
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
