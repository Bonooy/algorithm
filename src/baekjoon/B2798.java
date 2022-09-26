package baekjoon;

import java.util.Scanner;

public class B2798 {    // 블랙잭 (브루트포스)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int res = search(arr, N, M);

        System.out.println(res);
    }

    static int search(int[] arr, int N, int M) {
        int res = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {

                    int tot = arr[i] + arr[j] + arr[k];

                    if (tot == M) { // 세 카드의 합이 M과 같다면 종료
                        return tot;
                    }

                    // 세 카드의 합이 M보다 작으면서 이전 합보다는 크면 결과 갱신
                    if (tot < M && res < tot) {
                        res = tot;
                    }
                }
            }
        }
        return res;
    }
}
