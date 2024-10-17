package doyoCodingtest;

import java.io.*;
import java.util.*;

public class P18230_0915 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 가로 크기
        int A = Integer.parseInt(st.nextToken()); // 2x1 타일의 갯수
        int B = Integer.parseInt(st.nextToken()); // 2x2 타일의 갯수


        //두번째 타일 정보  1은 2x1 크기의 타일 A갯수
        //두 개의 List<Integer>를 사용해 2x1 타일(tileOne)과 2x2 타일(tileTwo)의 예쁨 값을 저장한다.
        //ArrayList는 동적 배열이므로 크기가 고정되어 있지 않아 입력에 따라 데이터를 유연하게 저장할 수 있다.
        List<Integer> tileOne = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i< A; i++){
            tileOne.add(Integer.parseInt(st.nextToken()));
        }

        //2x2 크기의 타일 B의 예쁨을 의미하는 갯수
        //Integer[]를 사용하는 이유는 Collections.reverseOrder()를 이용해 내림차순 정렬을 하기 위함이다.
        //Arrays.sort() 메소드를 사용하여 기본형 타입인 int[]를 정렬할 때는 오름차순 정렬만 가능하다
        List<Integer> tileTwo = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<B; i++){
            tileTwo.add(Integer.parseInt(st.nextToken()));
        }

        //두 리스트를 내림차순으로 정리한다.
        //이 작업을 통해 예쁨 값이 큰 타일을 먼저 사용할 수 있도록 우선순위를 설정한다.
        //정렬 알고리즘은 일반적으로 시간 복잡도가 **O(A log A)**와 **O(B log B)**로 작동한다.
       tileOne.sort(Collections.reverseOrder());
       tileTwo.sort(Collections.reverseOrder());

        int answer = 0;

        //만약 N이 홀수라면, 남은 칸은 1칸이므로 2x1 타일 하나를 사용해야 한다.
        //타일 목록에서 가장 큰 예쁨 값을 가진 2x1 타일을 사용하고, 이를 답에 더한다.
        //ArrayList의 **remove(0)**는 리스트의 첫 번째 요소를 삭제하는데, 이 작업의 시간 복잡도는 **O(n)**이다. 리스트의 모든 요소가 한 칸씩 이동해야 하기 때문이다.
        if(N%2 == 1 && !tileOne.isEmpty()){
            answer += tileOne.get(0);
            tileOne.remove(0);
            N-=1;
        }

        //2x2 크기의 타일들을 채워나가며 탐색함
        //	남은 길이가 2일 때, 두 가지 경우를 고려한다.
        //	1.	2개의 2x1 타일을 사용하는 경우 (case1).
        //	2.	1개의 2x2 타일을 사용하는 경우 (case2).
        //	•	두 경우의 예쁨 값 중 더 큰 것을 선택하고, 해당 타일을 리스트에서 제거한다.
        //	•	tileOne.remove(0)은 첫 번째 요소를 제거하며, 리스트의 크기를 줄이므로 메모리를 절약할 수 있다.
        for(int k=0; k<N/2; k++){
            int case1=0, case2 =0;
            //2x1 타일을 2개 사용하는 경우
            if(tileOne.size() >=2){
                case1 = tileOne.get(0) + tileOne.get(1);
            }

            //2x2 타일을 사용하는 경우
            if(!tileTwo.isEmpty()){
                case2 = tileTwo.get(0);
            }

            //2x1 타일 두 개를 동시에 사용할 때 두 개의 타일을 제거
            if(case1>case2){
                answer+= case1;
                tileOne.remove(0);
                tileOne.remove(0);
            }else{
                answer += case2;
                tileTwo.remove(0);
            }
        }

        System.out.println(answer);
    }
}
