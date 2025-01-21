package doyoCodingtest.DoyoBaekJoon.test2024;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13702_1024 {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());  // 주전자의 개수
        int K = Integer.parseInt(st.nextToken());  // 친구 수 (은상 포함)

        long[] jugs = new long[N];  // 주전자의 용량을 저장하는 배열
        long maxCapacity = 0;  // 주전자 중 가장 큰 용량

        // N개의 주전자 용량을 입력받는 부분 수정
        for (int i = 0; i < N; i++) {
            jugs[i] = Long.parseLong(br.readLine());  // 한 줄씩 주전자의 용량을 입력받음
            if (jugs[i] > maxCapacity) {
                maxCapacity = jugs[i];  // 최대 용량을 업데이트
            }
        }

        // 이분 탐색 설정
        long left = 1;  // 최소 용량
        long right = maxCapacity;  // 최대 용량
        long result = 0;  // 정답

        while (left <= right) {
            long mid = (left + right) / 2;  // 중간값
            long totalPeople = 0;

            // 각 주전자에서 mid ml로 몇 명에게 나눠줄 수 있는지 계산
            for (long jug : jugs) {
                totalPeople += jug / mid;  // 주전자에서 mid로 나눌 수 있는 인원 수
            }

            // mid ml로 K명 이상에게 나눠줄 수 있는 경우
            if (totalPeople >= K) {
                result = mid;  // 현재 mid가 유효하므로 결과 업데이트
                left = mid + 1;  // 더 큰 용량을 시도
            } else {
                right = mid - 1;  // 너무 많은 인원을 나눌 수 없으니 용량을 줄임
            }
        }

        System.out.println(result);  // 최종적으로 K명에게 나눠줄 수 있는 최대 용량 출력
    }

}
