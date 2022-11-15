package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B13706 {
    public static void main(String[] args) throws IOException { // (이분탐색) 제곱근
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        BigInteger N = new BigInteger(br.readLine());
        BigInteger mid;
        BigInteger start = new BigInteger("1");
        BigInteger end = N;

        while (true) {
            mid = start.add(end);
            mid = mid.divide(new BigInteger("2"));

            int res = (mid.multiply(mid)).compareTo(N);  // N과 비교
            if (res == 0) break; // 같다
            else if (res == 1) { // N보다 클 경우
                end = mid.subtract(new BigInteger("1"));
            }
            else {  // N보다 작을 경우
                start = mid.add(new BigInteger("1"));
            }
        }
        sb.append(mid);
        System.out.println(sb);
        br.close();
    }
}
