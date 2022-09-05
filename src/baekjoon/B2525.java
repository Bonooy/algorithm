package baekjoon;

import java.util.Scanner;

public class B2525 {    // 오븐시계

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        sc.close();

        int time = 60 * A + B;
        time += C;

        int hour = (time / 60) % 24;
        int minute = time % 60;

        System.out.println(hour + " " + minute);
    }
}
