package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
    static int node, line, start;
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }
        dfs(start);
        sb.append("\n");
        check = new boolean[node + 1];
        bfs(start);

        System.out.println(sb);
    }

    private static void dfs(int start) {
        check[start] = true;
        sb.append(start + " ");
        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        q.add(start);
        check[start] = true;
        while (!q.isEmpty()) {
            start = q.poll();
            /**
             * q.poll()
             * 큐 맨 앞에 있는 값 반환 후 삭제
             * 큐가 비어있을 경우 null 반환
             */
            sb.append(start + " ");

            for (int i = 1; i <= node; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
