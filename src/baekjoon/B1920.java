package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1920 {    // (이분탐색) 수 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[20000001];

        int N = Integer.parseInt(br.readLine()); // 원소를 인덱스 삼아 숫자의 개수 카운팅

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(st.nextToken()) + 10000000]++;
        }


        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());    // 남아있는 토큰 확인
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(cnt[Integer.parseInt(st.nextToken()) + 10000000]).append(' ');
        }
        System.out.println(sb);
    }
}

