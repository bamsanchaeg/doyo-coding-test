package doyoCodingtest.DoyoBaekJoon.test2024;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class BOJ10814_1105 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Member> members = new ArrayList<>();

        // 입력 받기
        for (int i = 0; i < n; i++) {
            int age = scanner.nextInt();
            String name = scanner.next();
            members.add(new Member(age, name, i)); // order를 i로 설정하여 가입 순서 저장
        }

        // 정렬
        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                // 나이 기준 오름차순 정렬
                if (m1.age != m2.age) {
                    return Integer.compare(m1.age, m2.age);
                } else {
                    // 나이가 같을 경우 가입 순서(order) 기준 오름차순
                    return Integer.compare(m1.order, m2.order);
                }
            }
        });

        // 출력
        for (Member member : members) {
            System.out.println(member);
        }

        scanner.close();
    }
}

class Member {
    int age;
    String name;
    int order; // 가입 순서를 나타내는 변수

    public Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }
}
