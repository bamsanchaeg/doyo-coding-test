package doyoCodingtest.DoyoProgrammers.Solution0721;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 정수 n과 정수 배열 numlist가 매개변수로 주어질 때,
 * numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.
 *
 * **/

//클래스와 메소드 호출하는 개념 인강 자료보고 다시 정리하기.
public class Solution4 {

    public static void main(String[] args)throws IOException {

    }

    //배열이 자유롭게 증가해야해서 ArrayList 사용해서 증가시킨 후 배열로 바꿔주는 작업 수행함.
    //변수 두개를 받아와하는데 입력장치 선언은 안해서 불가할듯.. 여튼 이렇게 풀었습니다.
    public int[] solution(int n, int[] numlist) {

        ArrayList<Integer> answerList = new ArrayList<>();

        //for 문에서 numlist.length-1을 하지 않음.. 배열을 끝까지 돌아야 마지막 값까지 볼 수 있어서.
        for(int i=0; i<numlist.length; i++){
            if(numlist[i]%n == 0){
                answerList.add(numlist[i]);
            }
        }

        //배열리스트를 다시 배열로 바꿔주는 과정
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }



}
