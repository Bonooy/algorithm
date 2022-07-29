package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class b2108_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); // 오름차순 정렬


        System.out.println(avg(arr));
        System.out.println(med(arr));
        System.out.println(mode(arr));
        System.out.println(range(arr));

    }

    //산술평균 메소드
    static int avg(int[] arr) {

        double result =0;
        double sum=0;

        for(int x : arr) {
            sum += x;
        }
        result = Math.round(sum / arr.length);

        return (int)Math.ceil(result);
    }

    // 중앙값 메소드
    static int med(int[] arr) {

        return arr[(arr.length/2)]; // 그냥 2로 나누기
    }

    // 최빈값 메소드
    static int mode(int[] arr) {

        int cnt[] = new int [8001]; // 절대값 4000 이하
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        int max = Integer.MIN_VALUE; // 최빈값을 위한 비교변수

        for(int x:arr) {
            if(x < 0) {
                cnt[Math.abs(x)+4000]++;
                // 음수의 경우 4000을 더해서 인덱스 증가
            }
            else cnt[x]++;
        }


        for(int i=0;i<cnt.length;i++) {
            if(cnt[i]!=0 && cnt[i]>max) {
                max = cnt[i];
            }
        }

        for(int i=0;i<cnt.length;i++) {
            int x=i;
            if(cnt[i]==max) { // 카운트 배열의 값들과 최빈값과 일치하면,
                if(i>4000) { // 4000이상은 음수를 바꿔준것이므로 다시 원래의 숫자로 교체
                    x-=4000;
                    x*=-1;
                    arrayList.add(x);
                }else
                    arrayList.add(i);
            }
        }
        Collections.sort(arrayList); // 추가 된 최빈값들이 다수 존재하면 오름차순 정렬

        if(arrayList.size()>1) return arrayList.get(1); // 최빈값이 여러개 존재한다면, 가장 작은 숫자에서 두 번째 숫자를 반환
        else return arrayList.get(0);
    }

    static int range(int[] arr) {

        return arr[arr.length-1] - arr[0];
    }
}