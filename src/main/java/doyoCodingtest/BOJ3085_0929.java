package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ3085_0929 {

    public static int N;
    public static char[][] candis;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        candis = new char[N][N];
        for(int i = 0; i<N; i++){
            String row = br.readLine();
            //String 객체를 단어 하나하나로 쪼개기
            candis[i] = row.toCharArray();

        }

        int maxCandis = 0;

        //인접한 사탕 교환 후 최대 개수 계산
        for(int i =0; i<N; i++){
            for(int j=0; j<N; j++){
                //오른쪽 사탕과 교환
                if(j + 1<N){
                    swap(candis, i, j, i, j + 1);
                    maxCandis = Math.max(maxCandis,checkMaxCandis(candis,N));
                    swap(candis, i, j, i, j + 1);//원상복구
                }

                //아래쪽 사탕과 교환
                if(i +1 <N){
                    swap(candis, i,j, i+1, j);
                    maxCandis = Math.max(maxCandis, checkMaxCandis(candis, N));
                    swap(candis,i,j,i+1,j);//원상복구
                }
            }
        }

        System.out.println(maxCandis);

    }

    public static int checkMaxCandis(char[][] board, int N){
        int maxCandis = 1;

        //행을 확인
        for(int i=0; i<N; i++){
            int count =1;
            for(int j=1; j<N; j++){
                if(board[i][j] == board[i][j-1]){
                    count++;
                }else{
                    maxCandis = Math.max(maxCandis,count);
                    count = 1;
                }
            }
            maxCandis = Math.max(maxCandis, count); // 마지막 연속 구간 확인
        }

        //열을 확인
        for(int i =0; i<N; i++){
            int count =1;
            for(int j=1; j<N; j++){
                if(board[j][i] == board[j-1][i]){
                    count++;
                }else{
                    maxCandis = Math.max(maxCandis, count);
                }
            }
            maxCandis = Math.max(maxCandis, count);
        }

        return maxCandis;

    }

    //배열의 두 원소를 교환하는 메소드
    public static void swap(char[][] board, int x1, int y1, int x2, int y2){
        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }
}
