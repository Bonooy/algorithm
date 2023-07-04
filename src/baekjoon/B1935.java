package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Double> stack = new Stack<>();
        String st = br.readLine();
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i]  = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            double res = 0;
            if (ch - 65 >= 0 && ch - 65 <= 26) {
                stack.push(arr[ch - 65]);
            } else {
                double a = stack.pop();
                double b = stack.pop();
                switch (String.valueOf(ch)) {
                    case "+":
                        res = b + a;
                        stack.push(res);
                        break;
                    case "*":
                        res = b * a;
                        stack.push(res);
                        break;
                    case "-":
                        res = b-a;
                        stack.push(res);
                        break;
                    case "/":
                        res = b / a;
                        stack.push(res);
                        break;
                }
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));

    }
}
