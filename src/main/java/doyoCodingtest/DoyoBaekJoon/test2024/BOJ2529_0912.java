package doyoCodingtest.DoyoBaekJoon.test2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2529_0912 {

    static String[] equalSign;
    static int[] numbers = {0,1,2,3,4,5,6,7,8,9};
    static List<String> results = new ArrayList<>();

    public static void main(String[] args)throws IOException {

        //주어진 숫자가 부등호의 방향에 맞춰지는가
        //각 부등호 값 마다의 완전탐색 설정
        //첫번째에 부등호 갯수 K가 주어짐
        //K의 갯수는 2보다 같거나 크고 9보다 작거나 같다
        //경우의 수는 부등호에 따라 다를 것 같음.
        //이미 선택된 숫자는 boolean 값으로 분리하여 중복 방지
        //최대,최소 정수를 출력하여야함

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //입력되는 부등호의 갯수
        int K = Integer.parseInt(br.readLine());
        equalSign = new String[K];

        //부등호의 정보 넣어주고 배열의 번호에 부등호 각각 넣어주기
        String[] tokens = br.readLine().split("\\s+"); // 정규 표현식으로 하나 이상의 공백을 기준으로 분리
        for(int i =0; i< equalSign.length; i++){
            equalSign[i] = tokens[i];
        }

        //부등호를 가지고 전체 갯수의 완전탐색을 진행해야한다. 숫자는 0에서 9까지이며 선택된 숫자는 모두 달라야 한다.
        //숫자의 중복사용을 방지하기 위한 배열
        boolean[] visited = new boolean[10];
        //배열리스트에 경우의 수를 넣어주기 위해 new ArrayList 생성

        dfs(equalSign, numbers, new ArrayList<>(),visited);

        System.out.println(results.get(results.size()-1));
        System.out.println(results.get(0));


    }

    public static void dfs(String[] equalSign, int[] numbers, List<Integer> currentList, boolean[] visited ){

        //리스트의 사이즈가 같을 때 ArrayList를 결과에 담아주는 것
        if (currentList.size() == equalSign.length + 1) {
            //문자열을 수정할 때 새로운 객체를 생성하지 않고, 내부적으로 버퍼를 사용하여 기존 문자열을 수정하기위해 사용
            //String 객체는 변경할 수 없다.
            StringBuilder nums = new StringBuilder();
            for(int num : currentList){
                //append로 숫자를 연결해서 붙여준다.
                nums.append(num);
            }
            //출력시 toString 사용
            results.add(nums.toString());
            return;
        }

        //currentList는 현재까지 선택된 숫자들을 저장하는 리스트이다.
        //0부터 9까지의 숫자 중에서 선택
        for(int i=0; i <=9; i++){
            if(!visited[i]){//중복숫자방지
                //처음 숫자 무조건 추가
                if(currentList.isEmpty()){
                    visited[i] = true;
                    currentList.add(numbers[i]);
                    //재귀적 호출
                    //현재 상태에서 다음 숫자를 선택하기 위해 다시 dfs를 호출한다.
                    dfs(equalSign,numbers,currentList,visited);
                    //재귀 호출 후 선택했던 숫자를 currentList에서 제거하고 해당 숫자가 다시 방문되지 않도록 상태를 변경함.
                    visited[i] = false;
                    currentList.remove(currentList.size()-1);
                }else{
                    //마지막에 추가된 숫자(마지막에 추가된 숫자 반환), 리스트에서 get 을 사용해서 숫자 정보를 가져온다.
                    int lastNum = currentList.get(currentList.size()-1);

                    if(currentList.size()-1 <equalSign.length){

                        //부등호 조건 확인, 인덱스를 사용하기 위해 마지막 요소의위치를 계산하는 과정
                        if(equalSign[currentList.size() -1].equals(">") && lastNum >numbers[i]){
                            visited[i] = true;
                            currentList.add(numbers[i]);
                            dfs(equalSign,numbers,currentList,visited);
                            visited[i] = false;
                            //마지막 부분 지움
                            currentList.remove(currentList.size()-1);
                        }else if(equalSign[currentList.size()-1].equals("<") && lastNum < numbers[i]){
                            visited[i] = true;
                            currentList.add(numbers[i]);
                            dfs(equalSign, numbers, currentList, visited);
                            visited[i] = false;
                            currentList.remove(currentList.size()-1);
                        }

                    }
                }
            }
        }
    }
}
