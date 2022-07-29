package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2606 {    // 자료구조 bfs, dfs 사용 문제

    static boolean[] check;
    static int[][] arr;
    static int count = 0;

    static int node, line;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       //1 입력 받기 및 인접 행렬 값 넣ㄱ ㅣ
        node = Integer.parseInt(br.readLine()); // 노드의 개수
        line = Integer.parseInt(br.readLine()); // 간선의 개수

        arr = new int[node + 1][node + 1];  // 인접 행렬
        check = new boolean[node + 1];  // 바이러스 감염 여부 판단

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        // dfs 실행
        dfs(1); // dfs 초기값 1

        // 출력
        System.out.println(count - 1);

    }

    // DFS 구현
    public static void dfs(int start) {

        check[start] = true;
        count++;    // 바이러스 감염 -> 1씩 count

        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i])    // 인접 행렬의 시작 노드와 연결된 값이 1인지 확인 && 이미 감염되지 않은 노드인지 확인
                dfs(i); // 조건 만족시 dfs를 해당 노드로 다시 실행
        }   // 후에 1번 노드와 연결된 다음 노드의 check에 true가 입력되며 다시 count

    }
}
