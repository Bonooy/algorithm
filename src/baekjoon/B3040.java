package baekjoon;

import java.util.Scanner;

public class B3040 {
    public static void main(String[] args) {    //(브루트포스) 백설공주와 일곱난쟁이

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        int n1 = 0;
        int n2 = 0;
        int sum = 0;
        /**
         * n1, n2 -> 일곱 난쟁이가 아닌 난쟁이 둘
         */

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100 && i != j) {
                    n1 = i;
                    n2 = j;
                    break;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == n1 || i == n2) continue;
            System.out.println(arr[i]);
        }
        sc.close();
    }
}

/**
 * 난쟁이 9명의 숫자 합에서 난쟁이가 아닌 2명을 뺀 합이 100이 될 때까지 모든 경우의 수 탐색.
 */

