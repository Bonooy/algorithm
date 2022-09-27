package baekjoon;

import java.util.Scanner;

public class B14916 {
    public static void main(String[] args) { //(브루트포스) 거스름돈

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = check(n);

        System.out.println(cnt);

    }

    static int check(int n) {
        int cnt = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                cnt += n/5;
                break;
            }
            n -= 2;
            cnt++;
        }

        if (n < 0) {
            return -1;
        } else {
            return cnt;
        }
    }
}
