package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2422 {
    public static void main(String[] args) { //(브루트포스)한윤정이 이탈리아에 가서 아이스크림을 사먹는데
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        try {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[][] check = new boolean[200][200];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int ice1 = Integer.parseInt(st.nextToken());
                int ice2 = Integer.parseInt(st.nextToken());
                check[ice1 - 1][ice2 - 1] = true;
                check[ice2 - 1][ice1 - 1] = true;
            }

            int res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        if (check[i][j] || check[i][k] || check[j][k]) {
                            continue;
                        } res++;
                    }
                }
            }System.out.println(res);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
