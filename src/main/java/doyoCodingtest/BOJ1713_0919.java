package doyoCodingtest;

import java.io.*;
import java.util.*;

public class BOJ1713_0919 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        //사진틀의 갯수
        int N = Integer.parseInt(br.readLine());
        //전체 학생의 총 추천 횟수
        int totalRecommendations = Integer.parseInt(br.readLine());
        //추천받은 학생의 정보 입력
        //N, totalRecommendations 읽는 순서: br.readLine()으로 읽은 데이터를 StringTokenizer로 처리하기 전에, 바로 int N, int totalRecommendations를 읽어야 한다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int [] recommendations = new int[totalRecommendations];
        for(int i =0; i<totalRecommendations; i++){
            recommendations[i] = Integer.parseInt(st.nextToken());
        }

        // 사진틀에 게시된 학생을 저장할 리스트
        List<Integer> frames = new ArrayList<>();
        // 각 학생의 추천 횟수 저장
        int[] recommendCount = new int[101];  // 학생 번호는 1~100이므로 크기를 101로 설정
        // 각 학생이 사진틀에 올라온 시간을 저장할 배열
        int[] time = new int[101];  // 각 학생이 언제 게시되었는지 기록하는 배열

        int currentTime = 0;

        //추천받은 학생 처리
        for(int student : recommendations){
            //이미 사진틀에 있으면 추천 횟수만 증가
            if(frames.contains(student)){
                //recommendCount에 추천받은 학생 추가
                recommendCount[student]++;
            }else{
                //사진들이 꽉 차지 않았으면 그냥 학생 번호 추가
                if(frames.size() < N){
                    frames.add(student);
                    recommendCount[student] = 1;
                    time[student] = currentTime; //0번째 배열에 저장된다
                }else{
                    //사진들이 꽉 찬 경우, 가장 추천 횟수가 적고 오래된 학생을 교체한다.
                    int minRecommend = Integer.MAX_VALUE;
                    int oldestStudent = -1;

                    for(int frameStudent : frames){
                        if(recommendCount[frameStudent] < minRecommend ||
                            (recommendCount[frameStudent] == minRecommend && time[frameStudent] < time[oldestStudent])){
                            minRecommend = recommendCount[frameStudent];
                            oldestStudent = frameStudent;
                        }
                    }

                    //가장 오래되고 추천 횟수가 적은 학생 제거
                    frames.remove(Integer.valueOf(oldestStudent));
                    recommendCount[oldestStudent] = 0;

                    //새로운 학생 추가
                    frames.add(student);
                    recommendCount[student] = 1;
                    time[student] = currentTime;
                }
            }
        }

        //사진틀에 남에있는 학생들을 번호순으로 정렬하여 출력
        Collections.sort(frames);
        for(int student: frames){
            System.out.print(student + " ");
        }
    }
}
