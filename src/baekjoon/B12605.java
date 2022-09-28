package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B12605 {   //(스택)단어순서 뒤집기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] strArr = str.split(" ");

            for (int j = 0; j < strArr.length; j++) {
                stack.push(strArr[j]);
            }
            sb.append("Case #" + (i + 1) + ": ");

            for (int j = 0; j < strArr.length; j++) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
