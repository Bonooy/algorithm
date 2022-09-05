package baekjoon;

import java.util.Scanner;

public class B1110 {    // 더하기 사이클

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();

        int next = N;
        int count = 0;

        while(true) {
            N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
            count++;
            if (next==N) break;
        }
        System.out.println(count);
    }
}
