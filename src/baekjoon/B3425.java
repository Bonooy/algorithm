package baekjoon;

import java.io.*;
import java.util.ArrayList;

public class B3425 {
    private static ArrayList<String> list = new ArrayList<>();
    private static long[] stack = new long[1001];
    private static int head = 0;
    private static int MAX = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            list.clear();
            String line = br.readLine();

            if (line.equals("QUIT")) break;
            while (!line.equals("END")) {
                String[] splitLine = line.split(" ");
                if (splitLine.length == 1) {
                    list.add(splitLine[0]);
                } else {
                    list.add(splitLine[0]);
                    list.add(splitLine[1]);
                }
                line = br.readLine();
            }

            int testCase = Integer.parseInt(br.readLine());

            for (int x = 0; x < testCase; x++) {
                int num = Integer.parseInt(br.readLine());

                if (GoStack(num)) {
                    sb.append(stack[0]).append("\n");
                } else {
                    sb.append("ERROR\n");
                }
            }
            sb.append("\n");
            br.readLine();
        }
        System.out.println(sb);

    }

    public static boolean GoStack(int now) {
        int listSize = list.size();
        head = 0;
        stack[head++] = now;

        for (int x = 0; x < listSize; x++) {
            if (list.get(x).equals("NUM")) {

                stack[head++] = Long.parseLong(list.get(x + 1));
                x++;
            } else if (list.get(x).equals("POP")) {
                if(head<1)
                    return false;

                head--;

            } else if (list.get(x).equals("INV")) {

                if(head<1)
                    return false;

                stack[head - 1] *= -1;

            } else if (list.get(x).equals("DUP")) {

                if (head < 1) {
                    return false;
                }

                stack[head] = stack[head - 1];
                head++;

            } else if (list.get(x).equals("SWP")) {

                if(head<2)
                    return false;

                long temp = stack[head - 1];
                stack[head - 1] = stack[head - 2];
                stack[head - 2] = temp;
            } else if (list.get(x).equals("ADD")) {

                if(head<2)
                    return false;

                if (Math.abs(stack[head - 1] + stack[head - 2]) > MAX) {
                    return false;
                }

                stack[head - 2] = stack[head - 1] + stack[head - 2];
                head--;

            } else if (list.get(x).equals("SUB")) {
                if(head<2)
                    return false;

                if (Math.abs(stack[head - 2] - stack[head - 1]) > MAX) {

                    return false;
                }

                stack[head - 2] = stack[head - 2] - stack[head - 1];
                head--;


            } else if (list.get(x).equals("MUL")) {
                if(head<2)
                    return false;

                if (Math.abs(stack[head - 2] * stack[head - 1]) > MAX) {
                    return false;
                }

                stack[head - 2] = stack[head - 2] * stack[head - 1];
                head--;
            } else if (list.get(x).equals("DIV")) {
                if(head<2)
                    return false;

                if(stack[head-1]==0)
                    return false;

                stack[head - 2] = stack[head - 2] / stack[head - 1];
                head--;
            } else {
                // MOD

                if(head<2)
                    return false;

                if(stack[head-1]==0)
                    return false;

                stack[head - 2] = stack[head - 2] % stack[head - 1];
                head--;
            }
        }
        if (head == 1) return true;
        return false;

    }

}
