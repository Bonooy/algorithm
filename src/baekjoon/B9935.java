package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Stack;

public class B9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String bombStr = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= bombStr.length()) {
                boolean isSame = true;
                for (int j = 0; j < bombStr.length(); j++) {
                    if (stack.get(stack.size() - bombStr.length() + j) != bombStr.charAt(j)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    for (int j = 0; j < bombStr.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        for (char c : stack) {
            sb.append(c);
        }

        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
        br.close();

    }
}
