package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11866_1207 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N : 사람 수, K: K번째 제거
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(getJosephusSequence(N,K));

    }

    public static String getJosephusSequence(int N, int K){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        //1번부터 N번까지 큐에 삽입
        for(int i = 1; i<=N; i++){
            queue.add(i);
        }

        //K번째 사람제거
        while (!queue.isEmpty()){
            //K-1명은 다시 큐 뒤로 삽입
            for(int i = 1; i<K;i++){
                queue.add(queue.poll());
            }
            //K번째 사람 제거하고 결과 리스트에 추가
            result.add(queue.poll());
        }

        //결과를 요세푸스 순열 형식으로 출력
        return "<" + String.join(", ", result.stream().map(String::valueOf).toArray(String[]::new)) + ">";
    }
}
