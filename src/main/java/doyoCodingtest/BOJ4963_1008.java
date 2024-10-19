package doyoCodingtest;

import java.util.*;
import java.io.*;
public class BOJ4963_1008 {
    static int[][] map;
    static int W;
    static int H;
    //8가지 방향 : 상,하,좌,우,대각선
    static int[] dx = {-1,-1,-1,0,1,1,1,0};
    static int[] dy = {-1,0,1,1,1,0,-1,-1};

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            // 입력이 "0 0"이면 종료
            if(W == 0 && H == 0){
                break;
            }

            map = new int[H][W];

            //섬과 바다 지도 정보 입력받기
            for(int i=0; i< H; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[][] visited = new boolean[H][W];
            int landCount = 0;

            //모든 좌표를 순회
            for(int i=0; i< H; i++){
                for(int j=0; j< W; j++){
                    //아직 방문하지 않은 땅을 발견하면 새로운 섬으로 처리
                    if(map[i][j] == 1 && !visited[i][j]){
                        bfs(map,i,j,visited);
                        landCount++; //새로운 섬을 발견할때마다 카운트 증가
                    }
                }
            }

            System.out.println(landCount);
        }




    }

    public static void bfs(int[][] map, int startX, int startY, boolean[][] visited){

      //BFS에서 사용할 큐를 초기화한다. LinkedList를 사용하여 큐를 구현한다.
       Queue<int[]> queue = new LinkedList<>();
       //시작 좌표를 queue에 추가한다. 이차원 배열을 일차원 배열로 저장해 x는 배열의 0번째, y는 1번째이다.
       queue.offer(new int[]{startX, startY});
       //시작 좌표를 방문한 것으로 표시한다.
       visited[startX][startY] = true;

       //Queue가 비어있지 않은 동안 BFS를 진행한다.
       while (!queue.isEmpty()){
           //현재 좌표를 꺼내고 해당 좌표의 x와 y값을 각각 x와 y에 저장한다.
           //
           int[] current = queue.poll();
           int x = current[0];
           int y = current[1];

           //8방향 탐색
           for(int i =0; i < 8; i++){
               int newX = x + dx[i];
               int newY = y + dy[i];

               if(newX >= 0 && newY >= 0 && newX < map.length && newY < map[0].length && !visited[newX][newY]){
                   if(map[newX][newY] ==1){
                       visited[newX][newY] = true;
                       queue.offer(new int[]{newX,newY});
                   }
               }
           }
       }
    }

}
