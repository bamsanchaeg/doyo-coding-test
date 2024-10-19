package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P13335_1018 {
    static int N;
    static int W;
    static int L;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int[] truckWeights = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<N; i++){
            truckWeights[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 다리의 차선 정보를 초기 값으로 만듭니다.
        Queue<Integer> bridge = new LinkedList<>(Collections.nCopies(W, 0));

        // 3. 시간 흐름을 시뮬레이션 합니다.
        int time = 0;
        int index = 0;  // 트럭 배열의 인덱스
        int totalWeight = 0;

        while (!bridge.isEmpty()) {
            time++;

            // 3-1. 시간이 흐르면 제일 앞의 트럭을 pop합니다.
            totalWeight -= bridge.poll();

            // 3-2. 다리에 올라가야 할 트럭이 남아 있다면
            if (index < truckWeights.length) {
                // 3-3. 차선의 총 하중이 다리 하중보다 적다면 새로운 트럭을 차선에 올립니다.
                if (totalWeight + truckWeights[index] <= L) {
                    bridge.add(truckWeights[index]);
                    totalWeight += truckWeights[index];
                    index++;
                } else {
                    // 3-4. 그렇지 않다면 무게 0인 트럭을 올립니다.
                    bridge.add(0);
                }
            }
        }

        // 4. 결과 출력
        System.out.println(time);
    }

}
