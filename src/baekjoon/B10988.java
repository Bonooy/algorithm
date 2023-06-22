package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String st = br.readLine();
        int ans = 1;

        for (int i = 0; i < st.length(); i++) {
            char c = st.charAt(i);

            if (c != st.charAt(st.length() - i - 1)) {
                ans = 0;
                break;
            }
        }
        sb.append(ans);
        System.out.println(sb);
        br.close();
    }

}

