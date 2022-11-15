package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10816 {   //(이분탐색) 숫자 카드 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());    // 남아있는 토큰 확인
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {  // 찾는 값이 있는 경우
                sb.append(1).append('\n');
            }
            else{   // 찾는 값이 없는 경우
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
}
