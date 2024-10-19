package doyoCodingtest;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17266_1019 {

    static int N,M;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int[] positions = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i< M; i++){
            positions[i] = Integer.parseInt(st.nextToken());
        }

        int result = findMinHeight(N, M, positions);
        System.out.println(result);

        br.close();

    }

    //주어진 높이 H로 모든 구간을 밝힐 수 있는지 확인하는 함수
    public static boolean canLightAll(int H, int N, int[] positions){
        //첫번째 가로등이 0을 비출 수 있는 지 확인
        if(positions[0] - H > 0){
            return false;
        }

        //각 가로등이 다음 가로등까지 구간을 비출 수 있는지 확인
        for(int i = 1; i < positions.length; i++){
            if(positions[i-1] + H < positions[i] - H){
                return false;
            }
        }

        //마지막 가로등이 N을 비출 수 있는지 확인
        if(positions[positions.length - 1] + H < N){
            return false;
        }

        return true;
    }

    //이분 탐색을 통해 최소 높이를 구하는 함수
    public static int findMinHeight(int N, int M, int[] positions){
        int left = 1, right = N;
        int answer = right;

        while (left <= right){
            int mid = (left + right) / 2;
            if(canLightAll(mid, N, positions)){
                answer = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return answer;
    }


}
