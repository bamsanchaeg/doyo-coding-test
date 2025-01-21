package doyoCodingtest.DoyoBaekJoon.test2025;

import java.io.*;
import java.util.*;

public class BOJ2659_0926 {

    static int[] numbers = new int[4];
    static List<Integer> clockNumberList = new ArrayList<>();
    static Set<Integer> uniqueClockNumbers = new HashSet<>();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i =0; i<4; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        //전체 시계수 생성
        generateAllClockWiseNumbers();

        //입력된 숫자의 시계수
        int ClockWiserNumber = generateClockwiseNumber(numbers);
        int rank = contSmallerClockNumbers(ClockWiserNumber);

        System.out.println(rank);

    }


    //전체 시계수 구하는 방법
    // 중복을 제거하기 위해 시계수만 저장하는 Set 사용
    public static void generateAllClockWiseNumbers(){

        //1부터 9까지의 숫자를 사용한 4자리 수 조합을 생성
        int[] allNumbers = {1,2,3,4,5,6,7,8,9};
        int[] digits = new int[4];

        //1부터 9까지 숫자를 중복없이 4개씩 뽑아 모든 조합을 만듦
        generateCombination(allNumbers, digits, 0);

        //시계수를 오름차순으로 정렬하여 리스트로 저장.
        clockNumberList = new ArrayList<>(uniqueClockNumbers);
        Collections.sort(clockNumberList);



    }

    //중복되지 않은 숫자 조합을 재귀적으로 생성하는 함수
    public static void generateCombination(int[] allNumbers, int[] digits, int depth){
     //depth == 4 가 되면 4자리 숫자 조합이 완성되었음을 의미하므로
    // 더이상 재귀호출을 진행하지 않고 현재 선택된 4개의 숫자 조합을 가지고 시계수를 계산한다.
        if(depth == 4){
            int clockNumber = generateClockwiseNumber(digits);
            if(clockNumber >= 1000){
                uniqueClockNumbers.add(clockNumber);
            }
            return;
        }

        //향상된 for 문
        for (int allNumber : allNumbers) {
            //숫자를 하나씩 선택할때마다 depth가 1씩 증가한다. 4개의 숫자를 모두 선택하면 depth = 4 가 된다.
            digits[depth] = allNumber;//현재 depth 위치에 숫자를 저장
            //재귀 호출을 하면서 start지점과 depth지점에 1씩 더한다.
            generateCombination(allNumbers, digits, depth + 1);
        }

    }

    public static int contSmallerClockNumbers(int userClockNumber){
        int count = 0;
        for(int clockNumber: clockNumberList){
            if(clockNumber< userClockNumber){
                count++;
            }
        }
        return count;
    }


    //시계방향으로 여러 시작점에서 4자리수를 생성하고, 가장 작은 수를 출력해야함.
    public static int generateClockwiseNumber(int[] numbers){

        //시작점에 따라 시계방향으로 순서대로 4자리 숫자 생성
        String[] directions = new String[4];
        int[] intDirection = new int[directions.length];

        int top = numbers[0]; //위쪽
        int right = numbers[1];//오른쪽
        int bottom = numbers[2];//아래쪽
        int left = numbers[3];//왼쪽

        //시작점을 왼쪽에서 시작(left -> top -> right -> bottom)
        directions[0] = "" + top + left + right + bottom;
        directions[1] = "" + left + right + bottom + top;
        directions[2] = "" + right + bottom + top + left;
        directions[3] = "" + bottom + right + top + left;

        for(int i=0; i< directions.length; i++){
            intDirection[i] = Integer.parseInt(directions[i]);
        }

        /*
         * Arrays.sort(intDirection);
         * 최소값 출력
         * return intDirection[0];
         *
         * */

        // 시계수는 생성된 숫자들 중 가장 작은 수
        //자바에서 배열을 스트림으로 반환하고, 비어있는 경우 -1을 반환한다. 그렇지 않다면 배열 내의 최솟값이 반환된다.
         return Arrays.stream(intDirection).min().orElse(-1);
    }

    //시계수 인덱스의 순서 찾는 법
    public static int findRankOfClockNumber(int userClockNumber){
        //시계수 리스트에서 해당 시계수의 인덱스를 찾아 반환(index)함수 찾기, 인덱스는 0부터 시작함
        return clockNumberList.indexOf(userClockNumber) ;
    }
}
