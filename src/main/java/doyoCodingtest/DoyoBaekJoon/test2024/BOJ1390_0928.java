package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ1390_0928 {

    static int R,C; //행은 R이고 열은 칼럼의 C이다.
    static int sr, sc;
    static int or, oc;
    static int[] dx = {-1,1,0,0};//가로측 이동(왼쪽 오른쪽 3,4 값 해당)
    static int [] dy = {0,0,-1,1};//세로축 이동(위,아래, 1,2 값 해당)
    static boolean[][] visited;
    static int dirIdx = 0; //현재 방향 시작 인덱스
    static int[] direction;//방향 배열

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //방문 배열 설정
        visited = new boolean[R][C];
        int[][] room = new int[R][C];

        st = new StringTokenizer(br.readLine());
        int obstacle = Integer.parseInt(st.nextToken());

        //장애물의 위치
        for(int i = 0; i<obstacle; i++ ){
            st = new StringTokenizer(br.readLine(), " ");
            or = Integer.parseInt(st.nextToken());
            oc = Integer.parseInt(st.nextToken());
            room[or][oc] = 2;
        }


        st = new StringTokenizer(br.readLine(), " ");
        //로봇의 시작위치
        sr = Integer.parseInt(st.nextToken()); //robotX
        sc = Integer.parseInt(st.nextToken()); // robotY

        room[sr][sc] = 1;

        //배열 초기화 선언 //1은 위 방향, 2는 아래 방향, 3은 왼쪽, 4는 오른쪽 direction
        direction = new int[4];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++){
            direction[i] = Integer.parseInt(st.nextToken()) - 1; // 0-based index로 변경
        }

        bfs(room,sr,sc);
        // 최종 위치 출력
        System.out.println(sr + " " + sc);

    }

    // BFS 탐색 함수
    private static void bfs(int[][] room, int curX, int curY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[curX][curY] = true;
        queue.offer(new int[]{curX, curY});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int d = direction[(dirIdx + i) % 4]; // 순서대로 방향 선택
                int nx = cur[0] + dx[d]; // 다음 x 좌표
                int ny = cur[1] + dy[d]; // 다음 y 좌표

                // 범위를 벗어나거나, 이미 방문했거나, 장애물인 경우 무시
                if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || room[nx][ny] == 2) {
                    continue;
                }

                // 이동 가능한 경우
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
                dirIdx = (dirIdx + i) % 4; // 현재 방향 업데이트
                sr = nx; // 최종 위치 업데이트
                sc = ny;
                break; // 이동한 후 반복문 종료
            }
        }


    }


}
