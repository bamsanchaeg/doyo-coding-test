package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.*;
import java.util.*;

public class BOJ1916_0923 {

    static int N;
    static int M;
    static ArrayList<Node>[] graph;
    static int[] minCost;
    static class Node implements Comparable<Node> {
        int city, cost;

        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 버스 경로 정보 입력
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end,cost));
        }

        // 시작 도시와 도착 도시 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        // 최소 비용 계산
        minCost = new int[N + 1];
        Arrays.fill(minCost, Integer.MAX_VALUE); // 무한대로 초기화

        dijkstra(startCity);
        System.out.println(minCost[endCity]);

    }

    //디익스트라
    public static void dijkstra(int startCity){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        //add()와 offer()는 기본적으로 같은 기능을 수행하지만, offer()는 큐가 가득 찼을 때 false를 반환할 수 있다
        pq.offer(new Node(startCity, 0));
        minCost[startCity] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentCity = current.city;
            int currentCost = current.cost;

            // 이미 처리된 도시라면 무시
            if (currentCost > minCost[currentCity]) continue;

            // 연결된 도시 탐색
            for (Node neighbor : graph[currentCity]) {
                int newCost = currentCost + neighbor.cost;
                if (newCost < minCost[neighbor.city]) {
                    minCost[neighbor.city] = newCost;
                    pq.offer(new Node(neighbor.city, newCost));
                }
            }
        }

    }

}