package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2667 {

    static int N;
    static int[][] map;
    static boolean[][] check;

    static int cnt;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt = 0;
                if (map[i][j] == 1) {
                    dfs(i, j);
                    arr.add(cnt);
                    res++;
                }
            }
        }

        Collections.sort(arr);
        System.out.println(res);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void dfs(int x, int y) {
        map[x][y] = 0;
        cnt += 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
