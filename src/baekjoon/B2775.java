package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2775 {  // (DP) 부녀회장이 될테야

    public static int[][] apt = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        makeApt();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(apt[k][n]).append('\n');
        }
        System.out.println(sb);
    }

    public static void makeApt() {  // 아파트 설계

        for (int i = 0; i < 15; i++) {
            apt[i][1] = 1;  // i층 1호
            apt[0][i] = i;  // 0층 i호
        }

        for (int j = 1; j < 15; j++) {
            for (int k = 2; k < 15; k++) {
                apt[j][k] = apt[j][k - 1] + apt[j - 1][k];
            }
        }
    }
}
