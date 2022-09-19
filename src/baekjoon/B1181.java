package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class B1181 {    // 단어 정렬 (정렬)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }


        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                else {
                    return o1.length() - o2.length();
                }
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.append(arr[0]).append('\n');

        for (int i = 1; i < N; i++) {
            if (!arr[i].equals(arr[i - 1])) {
                bw.append(arr[i]).append('\n');
            }
        }
        bw.flush();
        bw.close();
        System.out.println(bw);
    }
}
