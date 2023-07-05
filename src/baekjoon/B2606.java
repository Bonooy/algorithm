package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2606 {    // 자료구조 bfs, dfs 사용 문제

    static boolean[] check;
    static int[][] arr;
    static int count = 0;
    static int node, line;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];  // 바이러스 감염 여부 판단

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);

        System.out.println(count - 1);
    }

    public static void dfs(int start) {

        check[start] = true;
        count++;    // 바이러스 감염 -> 1씩 count

        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i])    // 인접 행렬의 시작 노드와 연결된 값이 1인지 확인 && 이미 감염되지 않은 노드인지 확인
                dfs(i);
        }

    }
}
