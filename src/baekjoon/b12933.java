package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b12933 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[6];
        int s = str.length();
        int m = 0;
        arr[0] = s;
        for (int i = 0; i < s; i++) {
            int n = 0;
            if (str.charAt(i) == 'q') n = 1;
            if (str.charAt(i) == 'u') n = 2;
            if (str.charAt(i) == 'a') n = 3;
            if (str.charAt(i) == 'c') n = 4;
            if (str.charAt(i) == 'k') n = 5;
            if (arr[n-1] == 0) {
                System.out.println("-1");
                return;
            }
            arr[n]++; arr[n-1]--;
            m = Math.max(m, arr[1] + arr[2]+ arr[3] + arr[4]);
        }
        if (arr[5] * 5 != s) {
            System.out.println("-1");
            return;
        }
        System.out.println(m);
    }
}

// if) q, u, a, c, k 를 1, 2, 3, 4, 5
//1. n-1 >= n
//2. 최대 오리의 수 = 1, 2, 3, 4 합
//3. 5 = 음성의 길이/5 만큼
