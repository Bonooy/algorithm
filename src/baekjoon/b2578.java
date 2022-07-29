package baekjoon;

import java.util.Scanner;

public class b2578 {

    static int[][] bingo = new int[5][5];
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {   //input
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 25; i++) {  //  사회자의 숫자
            int num = sc.nextInt();
            answer++;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {

                    if (bingo[j][k] == num) {
                        bingo[j][k] = -1;

                        if (check(j, k) >= 3) {
                            System.out.println(answer);
                            return;
                        }
                    }
                }
            }
        }
    }

    private static int check(int r, int c) {
        int count = 0;
        for (int i = 0; i < 5; i++) {   // 행
            int rCount = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == -1) rCount++;
            }
            if (rCount == 5) count++;
        }

        for (int i = 0; i < 5; i++) {   // 열
            int cCount = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == -1) cCount++;
            }
            if (cCount == 5) count++;
        }

        int cCount = 0;
        for ( int i=0; i<5; i++) {  // 우하향 대각선
            if (bingo[i][i] == -1) cCount++;
            if (cCount == 5) count++;
        }

        cCount= 0;
        for (int i = 4; i >= 0; i--) {  // 우상향 대각선
            if (bingo[4-i][i] == -1) cCount++;
            if (cCount == 5) count++;
        }
        return count;
    }
}


// 1. 빙고판 숫자들이 사회자가 부른 숫자와 일치할 경우 그 숫자를 -1로 변환
// 2. 행, 열, 대각선을 확인하여 -1이 5개면 빙고 카운트 개수를 증가
// 3. 빙고 카운트가 3개 이상이 되면 -1이 된 숫자의 개수를 출력