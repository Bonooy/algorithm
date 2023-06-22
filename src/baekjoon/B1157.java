package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[26];
        String st = br.readLine().toUpperCase();

        int max = -1;
        char c = '?';
        for (int i = 0; i < st.length(); i++) {
            arr[st.charAt(i)-65]++;
            if (max < arr[st.charAt(i) - 65]) {
                max = arr[st.charAt(i) - 65];
                c = st.charAt(i);
            }
            else if(max==arr[st.charAt(i)-65]) c = '?';

        }
        sb.append(c);
        System.out.println(sb);

    }
}
