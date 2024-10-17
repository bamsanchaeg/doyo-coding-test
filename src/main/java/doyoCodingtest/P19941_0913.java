package doyoCodingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19941_0913 {

    static char[] tableInfo;
    static int answer = 0;

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tableInfo = br.readLine().toCharArray();//식탁정보 배열형태로 저장(단일 정보가 필요하기 때문에 char 형태 사용)

        //식탁정보 탐색, 왼쪽과 오른쪽 범위 탐색 필요
        for(int i=0; i<N; i++){

            //사람일때 탐색 시작
            if(tableInfo[i] == 'P'){
                //최대로 갈 수 있는 범위, 0보다 더 큰 값을 반환함
                // i - K: 여기서 i는 어떤 인덱스 값이고, K는 그 인덱스에서 빼야 하는 값이다.
                // 0: 인덱스는 음수가 될 수 없으므로, 최소값으로 0을 지정한다.
                // 이 코드는 두 값을 비교하여, i - K가 0보다 크거나 같으면 그 값을 반환하고, 만약 i - K가 음수라면 0을 반환한다. 이는 배열이나 리스트에서 유효한 인덱스를 계산할 때 유용하다.
                int index = Math.max(i - K, 0);
                boolean check = false; //초기값 설정은 false로 설정

                for(int j = index; j<i; j++){
                    //먹을 수 있는 햄버거를 탐색한 경우 boolean 값 변경 후 탐색 종료, check 값은 변경되고 해당 햄버거의 값은 H에서 N으로 변경됨
                    if(eatenBurger(j)){
                        check = true;
                        break;
                    }
                }
                //왼쪽에 적절한 햄버거가 없을 시(for문 적용이 되지 않을때 아래 if문 조건 적용으로 다시 for문 적용)
                if(!check){
                    //배열의 경계를 넘어가는 것을 방지하고 유효한 인덱스를 변환하기 위해 사용하는 삼항연산자
                    //오른쪽으로 최대 K칸까지의 탐색 범위 설정
                   index = i + K >= N ? N-1 : i + K;
                   for(int j = i + 1; j <= index; j++){
                       //먹을 수 있는 햄버거를 탐색한 경우 boolean 값 변경 후 탐색 종료, check 값은 변경되고 해당 햄버거의 값은 H에서 N으로 변경됨
                       if(eatenBurger(j)){ // 먹을 수 있는 햄버거 발견
                           check = true;
                           break;
                       }
                   }
                }
            }

        }

        br.close();
        System.out.println(answer);

    }

    //범위 탐색할때 먹을 수 있는 햄버거인지 탐색
    static boolean eatenBurger(int index){
        if(tableInfo[index] == 'H'){
            tableInfo[index] = 'N'; //햄버거 먹었기 때문에 N로 변경
            answer++;
            //이 메서드는 햄버거를 찾으면 true를 반환해 탐색을 종료하고, 그렇지 않으면 false를 반환해 다른 범위를 탐색하도록 한다.
            //위의 if문으로 넘어가는 것과 같음.
            return true; // 먹기 성공
        }
        return false;

    }
}
