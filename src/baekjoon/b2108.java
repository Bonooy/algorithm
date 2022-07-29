package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2108 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[8001];    // 절댓값 4000이하

        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int med = 10000; // 중앙값
        int mode = 10000;    // 최빈값
        // med와 mode는 주어진 절댓값을 가진 수 범위에 해당하지 않는 수로 초기화

        int cnt = 0; // 중앙값의 빈도 누적 카운팅
        int modeMax = 0;   // 최빈값 중 최댓값
        boolean modeCheck = false; // 동일한 최빈값이 1번만 등장하면 true

        for(int i=0; i<N; i++) {
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[value+4000]++;

            if(max < value) {max = value;}
            if(min > value) {min = value;}
        }

        for(int i=min+4000; i<=max+4000; i++){
            if(arr[i] > 0) {
                /*
                 * <중앙값 >
                 * 누적횟수가 전체 전체 길이의 절반에 못 미친다면
                 */
                if(cnt<(N+1)/2){
                    cnt += arr[i];  // i값의 빈도수를 cnt에 누적
                    med = i - 4000;
                }

                /*
                 * <최빈값 찾기>
                 * 이전 최빈값보다 현재 값의 빈도수가 더 높을 경우
                 */
                if(modeMax<arr[i]) {
                    modeMax = arr[i];
                    mode = i - 4000;
                    modeCheck = true;
                }

                // 이전 최빈값 최댓값과 동일한 경우면서 한 번만 중복되는 경우
                else if(modeMax == arr[i] && modeCheck == true){
                    mode = i - 4000;
                    modeCheck = false;
                }
            }
        }

        System.out.println((int)Math.round((double)sum / N));	// 산술평균
        System.out.println(med);	// 중앙값
        System.out.println(mode);	// 최빈값
        System.out.println(max - min);	// 범위

    }
}




