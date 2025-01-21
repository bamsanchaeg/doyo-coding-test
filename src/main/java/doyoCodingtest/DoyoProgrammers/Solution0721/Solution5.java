package doyoCodingtest.DoyoProgrammers.Solution0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution5 {

    public static void main(String[] args) throws IOException {

        Map<Integer,Integer> answerMap = existMap();
        Integer mode = findMode(answerMap);

        System.out.println("Number frequencies: " + answerMap);
        System.out.println("Mode: " + mode);

    }

    public static Map<Integer,Integer> existMap() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[]{
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine()),
                Integer.parseInt(br.readLine()),
        };

        //새로운 맵 선언
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        //맵에 배열의 값과 빈도수를 같이 넣어준다.

        /**
         * getOrDefault는 자바의 Map 인터페이스에서 제공하는 메서드 중 하나로,
         * HashMap, TreeMap, LinkedHashMap 등 모든 Map 구현체에서 사용할 수 있습니다.
         *  이 메서드는 지정된 키가 맵에 존재할 때 해당 키에 대한 값을 반환하고, 키가 존재하지 않을 때는 제공된 기본값을 반환합니다.
          **/
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        };

        return frequencyMap;

    }

    public static Integer findMode(Map<Integer, Integer> frequencyMap){

        Integer mode = null;
        int maxCount = 0;


        /**빈도수 맵을 순회하며 최빈값 찾기
         * entrySet 메서드는 자바의 Map 인터페이스에서 제공하는 메서드 중 하나로,
         * 맵의 모든 엔트리(키-값 쌍)를 Set으로 반환합니다.
         * entrySet을 사용하면 맵의 모든 항목을 반복(iterate)하면서 처리할 수 있습니다.
         **/

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }

        return mode;
    }


}
