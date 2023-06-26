package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2751 {
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//        int[] arr = new int[N];
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        Arrays.sort(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }
//    }
    /**
     *  => 시간초과 오류
     *  원인 : Arrays.sort
     *  시간복잡도 : O(n^2)
     *
     *  해결 : Counting Sort를 사용
     *  시간복잡도 : O(n)
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[2000001];
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000000] = true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                sb.append((i - 1000000)).append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }
}
