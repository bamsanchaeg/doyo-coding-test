package doyoCodingtest.DoyoProgrammers.Solution0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 정수 배열 array가 매개변수로 주어질 때, 가장 큰 수와 그 수의 인덱스를 담은 배열을 return 하도록 solution 함수를 완성해보세요.
 **/
public class Solution3 {

    /**정렬없이 진행하는 경우 아래의 for 문으로 탐색전을 진행해도 된다.
     * 버블정렬에 대해서 잘 알아야할듯... 복습 다시다시
     * import java.util.*;

     class Solution {
     public int[] solution(int[] array) {

     int[] answer = new int[2];

     int maxValue = array[0];
     int maxIndex = 0;

     for (int i = 1; i < array.length; i++) {
     if (array[i] > maxValue) {
     maxValue = array[i];
     maxIndex = i;
     }
     }


     answer[0] = maxValue;
     answer[1] = maxIndex;

     return answer;
     }
     }
     * **/

    public static void main(String[] args)throws IOException {

        int[] getNumbers = newArray();

        /*
           배열을 stream으로 변환 후 최대값 찾는 API
           int max = Arrays.stream(array)
                           .max()
                           .getAsInt();
          **/


        for(int i = 0; i< getNumbers.length-1; i++){
            for(int j=0; j<getNumbers.length-i-1; j++){
                if(getNumbers[j] > getNumbers[j+1]){
                    // swap array[j] and array[j+1]
                    //temp에 j값이 더 클시 j번 배열의 값을 미리 담아둔 다음에
                    int temp = getNumbers[j];
                    //원래 j값에 더 작았던 j+1 값을 담아준다.
                    getNumbers[j] = getNumbers[j + 1];
                    //그리고 j+1값에 temp 에 담았던 j값을 다시 담아준다.
                    getNumbers[j + 1] = temp;
                }
            }
        }

        //최대값 출력하기.
        int max = IntStream.of(getNumbers).max().orElseThrow();

        System.out.println("정렬된 배열의 값은" + Arrays.toString(getNumbers));
        System.out.println("이 중 최대값은" + max + "입니다.");


    }


    public static int[] newArray() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //배열 안의 값 선언
        int[] newArray = new int[]{

                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine()),
                Integer.parseInt(reader.readLine())
        };

        return newArray;
    }
}
