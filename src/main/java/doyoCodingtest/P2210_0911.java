package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2210_0911 {

    static int[][] numbers = new int[5][5];
    //탐색방향 정의하기
    static int[] nx = {0,0,1,-1};//가로축 이동
    static int[] ny = {1,-1,0,0};//세로축 이동
    //중복된 값을 허용하지 않는 자료구조, 빠른 중복검사, 탐색 및 삽입기능 최적화를 위해 사용
    static HashSet<String> selectedNum = new HashSet<>();

    public static void main(String[] args)throws IOException {

        //각 이동을 했을때 숫자가 이전 숫자의 경우의 수와 겹치면 count 수를 빼는 방향으로 가는게 맞다.
        //아예 주어진 숫자의 다섯가지 조합을 살펴보는게 좋지 않을까?
        //이중배열정의
        //탐색방향 정의
        //DFS 구현
        //중복 수 처리
        //넣어진 숫자들은 리스트 형식으로 해시맵에 넣어준다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //5x5 배열 입력받기
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<5; j++){
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 배열의 모든 칸에서 DFS 시작
        // 이 과정에서 각 칸에서 출발하는 모든 가능한 경로를 탐색하고, 그 경로에 해당하는 숫자들을 이어붙여 6자리 숫자를 만든다.
        // (시작 행 위치, 시작 열 위치, 이동 횟수, 이어붙인 숫자)
        for(int i =0; i<5; i++){
            for(int j=0; j<5; j++){
                //dfs 시작
                getNumbers(i,j,0,"");
            }
        }

        //sizr()메소드를 이용하여 Hash의 크기를 구할 수 있다.
        System.out.println(selectedNum.size());

    }

    //dfs
    public static void getNumbers(int x, int y, int depth, String currentNumber){

        if(depth == 6){ //숫자가 다 완성되었을때
            selectedNum.add(currentNumber); //해시맵에 숫자 더해주기
            return;
        }

        //현재 위치의 숫자를 문자열에 추가해주기, 여기서 x와 y는 위의 for문을 참고하면 되며 0부터 시작한다.
        currentNumber += numbers[x][y];

        //추가해준 뒤 현 위치에서 숫자를 네 방향으로 이동
        //상하좌우값을 좌 우로 나눠 -1, 0으로 나눠두었다.
        for(int i=0; i<4; i++){
            int numX = x + nx[i];
            int numY = y + ny[i];

            //배열의 범위는 0보다 크고 5보다 작은 범위로 체크
            //각 방향으로 이동할때 배열의 범위를 벗어나지 않도록 확인하고 이동한 위치에서 다시 DFS 탐색을 재귀적으로 호출한다.
            //새로운 위치에서 다시 DFS 탐색을 진행함....
            if(numX >=0 && numY >= 0 && numX < 5 && numY < 5){
                getNumbers(numX,numY, depth+1, currentNumber);
            }
        }


    }
}
