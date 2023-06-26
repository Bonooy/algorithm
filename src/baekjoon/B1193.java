package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1193 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int diagonal = 1; // 대각선의 개수
        int prevSum = 0; // 대각선의 직전 누적합

        while (true) {

            if (X <= diagonal + prevSum) {
                if (diagonal % 2 == 1) {
                    System.out.println((diagonal - (X - prevSum - 1))+ "/" + (X - prevSum));
                    break;
                }
                else{
                    System.out.println((X - prevSum) + "/" + (diagonal - (X - prevSum - 1)));
                    break;
                }
            }
            else{
                prevSum += diagonal;
                diagonal++;
            }
        }


    }
}
