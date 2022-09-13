package baekjoon;

import java.io.*;


public class B11729 {   // 하노이탑 (재귀)

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        bw.write((int) (Math.pow(2, N) - 1) + "\n");

        hanoitop(N, 1, 2, 3);

        bw.flush();
        bw.close();

    }

    public static void hanoitop(int N, int start, int mid, int end) throws IOException {

        if(N==1){   // 원반수 1개라면
            bw.write(start + " " + end + "\n");
            return;
        }

        /**
         * 1번에서 3번으로 이동하는 상황
         * 1. N-1개의 원판을 1번에서 2번으로 이동
         * 2. 마지막 1개의 원판을 1번에서 3번으로 이동
         * 3. 2의 N-1개를 2번에서 3번으로 이동
         * (1번 = start, 2번 = mid, 3번 = end)
         */

        hanoitop(N-1, start, end, mid);
        bw.append(start + " " + end + "\n");
        hanoitop(N-1, mid, start, end);

    }

}
