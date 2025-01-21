package doyoCodingtest.DoyoProgrammers.solution0616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%,
// 50만 원 이상 사면 20%를 할인해줍니다.
// 구매한 옷의 가격 price가 주어질 때,
// 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.

//이 부분에서는 100% 에서 할인율을 뺀 뒤 가격을 생각하는게 새로운 사고의 전환이었다.
//double과 int형 변환에 주의하자.

public class Solution3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());

        //변수 초기화
        int answer = 0;

        if(price >= 100000 && price < 300000){
            answer = (int)(price*0.95);
        }else if(price >= 300000 && price < 500000){
            answer = (int)(price*0.9);
        }else if(price >= 500000){
            answer = (int)(price*0.8);
        }else{
            answer = price;
        }

        System.out.println("총 가격은" + answer + "원 입니다. 봉투 필요하실까요?");

    }
}