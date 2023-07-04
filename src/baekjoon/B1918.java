package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            switch (ch){
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(ch)) {
                        sb.append(stack.pop());
                    }
                    stack.add(ch);
                    break;
                case '(':
                    stack.add(ch);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());

    }

    // 연산 우선순위 정하는 함수
    private static int priority(Character op) {
        if(op=='(' || op==')'){
            return 0;
        } else if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return -1;

    }
}
