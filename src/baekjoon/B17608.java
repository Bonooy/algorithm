package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B17608 {   //(스택) 막대기
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int h = 0;

        for (int i = 0; i < N; i++) {
            h = Integer.parseInt(br.readLine());
            stack.push(h);
        }

        int cnt = 1;
        int std = stack.pop();

        /**
         * 기준(std) 막대기보다 현재(curr) 막대기가 크면 카운팅해주며 std를 curr로 교체
         */
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (curr > std) {
                std = curr;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
