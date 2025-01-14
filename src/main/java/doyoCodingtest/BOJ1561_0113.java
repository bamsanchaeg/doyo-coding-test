package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1561_0113 {
    static long numChildren; // 아이들의 수
    static int numRides; // 놀이기구의 수
    static int[] rideTimes; // 놀이기구 운행 시간 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        numChildren = Long.parseLong(st.nextToken());
        numRides = Integer.parseInt(st.nextToken());

        rideTimes = new int[numRides];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numRides; i++) {
            rideTimes[i] = Integer.parseInt(st.nextToken());
        }

        // 아이 수가 놀이기구 수보다 작거나 같으면 바로 처리 가능
        if (numChildren <= numRides) {
            System.out.println(numChildren);
            return;
        }

        // 이분탐색으로 마지막 아이가 탑승할 시간 찾기
        long minTime = findMinimumTime();

        // 마지막 아이가 탑승할 놀이기구 번호 찾기
        long childrenBefore = getTotalChildren(minTime - 1); // minTime 이전까지 탑승한 아이 수
        for (int i = 0; i < numRides; i++) {
            if (minTime % rideTimes[i] == 0) { // minTime에 사용 가능한 놀이기구
                childrenBefore++;
            }
            if (childrenBefore == numChildren) { // 마지막 아이가 이 놀이기구를 탄다면
                System.out.println(i + 1); // 놀이기구 번호 출력
                break;
            }
        }
    }

    // 특정 시간 t까지 탑승한 총 아이 수 계산
    private static long getTotalChildren(long t) {
        long total = numRides; // 초기 상태에서 모든 놀이기구가 첫 탑승한 아이 수
        for (int time : rideTimes) {
            total += t / time; // 각 놀이기구의 운행 횟수만큼 추가
        }
        return total;
    }

    // 이분탐색으로 마지막 아이가 탑승할 최소 시간을 찾기
    private static long findMinimumTime() {
        long left = 0;
        long right = numChildren * 30; // 충분히 큰 시간 설정
        long minTime = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long totalChildren = getTotalChildren(mid);

            if (totalChildren < numChildren) {
                left = mid + 1; // 더 큰 시간 탐색
            } else {
                minTime = mid; // 가능한 최소 시간 저장
                right = mid - 1; // 더 작은 시간 탐색
            }
        }
        return minTime;
    }
}
