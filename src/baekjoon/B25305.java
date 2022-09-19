package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B25305 {   // 커트라인 (정렬)

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());   // 내림차순 정렬

        System.out.println(arr[k-1]);   // k등의 점수 출력
    }
}
