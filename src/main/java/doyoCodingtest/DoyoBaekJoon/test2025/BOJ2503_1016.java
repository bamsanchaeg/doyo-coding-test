package doyoCodingtest.DoyoBaekJoon.test2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2503_1016 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 질문을 위한 새로운 배열 리스트
        List<Question> questions = new ArrayList<>();

        // N개의 줄에는 각 줄마다 민혁이가 질문한 세 자리 수와
        // 영수가 답한 스트라이크 개수를 나타내는 정수와
        // 볼의 개수를 나타내는 정수가 주어진다.
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            //배열에 split 된 숫자와 볼을 담는다.
            String[] parts = input.split(" ");
            int guess = Integer.parseInt(parts[0]);
            int strikes = Integer.parseInt(parts[1]);
            int balls = Integer.parseInt(parts[2]);
            questions.add(new Question(guess, strikes, balls));
        }

        int possibleCount = findPossibleAnswers(questions);
        System.out.println(possibleCount);
        br.close();
    }

    // 영수가 생각할 수 있는 가능한 숫자의 조합을 찾는 메서드
    private static int findPossibleAnswers(List<Question> questions) {
        int count = 0;

        // 123부터 987까지의 숫자 중 1-9의 서로 다른 숫자 3개로 이루어진 경우를 확인
        for (int num = 123; num <= 987; num++) {
            if (isValidNumber(num)) { // 유효한 숫자인지 확인
                boolean isPossible = true;

                for (Question question : questions) {
                    int[] result = getStrikeAndBall(num, question.guess);
                    int strikes = result[0];
                    int balls = result[1];

                    // 질문에 대한 답변이 맞지 않으면 이 숫자는 불가능
                    if (strikes != question.strikes || balls != question.balls) {
                        isPossible = false;
                        break;
                    }
                }

                if (isPossible) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] getStrikeAndBall(int answer, int guess) {
        int strikes = 0;
        int balls = 0;

        String answerStr = String.valueOf(answer);
        String guessStr = String.valueOf(guess);

        // 스트라이크 계산
        for (int i = 0; i < 3; i++) {
            if (answerStr.charAt(i) == guessStr.charAt(i)) {
                strikes++;
            }
        }

        // 볼 계산
        for (char g : guessStr.toCharArray()) {
            if (answerStr.indexOf(g) >= 0) { // 숫자가 포함되어 있는 경우
                balls++;
            }
        }
        balls -= strikes; // 스트라이크를 제외한 볼 수를 조정
        return new int[]{strikes, balls};
    }

    private static boolean isValidNumber(int num) {
        String str = Integer.toString(num);
        Set<Character> digitSet = new HashSet<>(); // HashSet으로 중복 가려내기

        for (char c : str.toCharArray()) {
            if (c == '0' || !digitSet.add(c)) {
                return false; // 0이 포함되거나 중복된 숫자가 있을 경우
            }
        }
        return true;
    }

    // 질문을 표현하는 클래스
    static class Question {
        int guess;
        int strikes;
        int balls;

        Question(int guess, int strikes, int balls) {
            this.guess = guess; // 오타 수정
            this.strikes = strikes;
            this.balls = balls;
        }
    }
}