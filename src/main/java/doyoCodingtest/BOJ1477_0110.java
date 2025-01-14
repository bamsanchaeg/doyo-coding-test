package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1477_0110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//현재 휴게소 개수
        int M = Integer.parseInt(st.nextToken()); //추가할 휴게소 개수
        int L = Integer.parseInt(st.nextToken()); //고속도로 길이

        int[] restStops = new int[N + 2]; //현재 휴게소의 시작, 끝 포함
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                restStops[i] = Integer.parseInt(st.nextToken());
            }
        }

        //고속도로 시작과 끝 추가
        restStops[0] = 0;
        restStops[N + 1] = L;
        Arrays.sort(restStops);

        //이분 탐색
        int left = 1; //최소 구간 길이
        int right = L; //최대 구간 길이
        int result = L;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAddRestStops(restStops, M, mid)) {
                result = mid;//가능하다면 최댓값 갱신
                right = mid - 1; //더 작은 구간 길이를 시도
            } else {
                left = mid + 1; //더 큰 구간 길이를 시도
            }
        }

        System.out.println(result);

    }

    private static boolean canAddRestStops(int[] restStops, int M, int maxGap) {
        int count = 0;
        for (int i = 1; i < restStops.length; i++) {
            int gap = restStops[i] - restStops[i - 1];
            if (gap > maxGap) {
                count += (gap - 1) / maxGap;//필요한 휴게소 개수
            }
        }

        return count <= M;
    }
}
