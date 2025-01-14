package BasicCodingStudy;

import java.util.*;

public class ImportantExam01 {

    public static void main(String[] args) {
        //배열 전체를 String 객체로 생성
        //String str = new String(byte[] bytes);
        //지정한 문자셋으로 디코딩
        //String str = new String(byte[] bytes, String charsetName);
        //배열의 offset 인덱스 위치부터 length만큼 String 객체로 생성
        //String str = new String(byte[] bytes, int offset, int lenght);
        //지정한 문자셋으로 디코딩
        //String str = new String(byte[] bytes, int offset, int length, String charsetName);

        //배열 전체를 String 객체로 생성
        byte[] bytes = {72, 101, 108, 108, 111, 32, 74, 97, 118, 97};
        String str1 = new String(bytes);
        System.out.println(str1);

        //배열의 offset 인덱스 위치부터 length만큼 String 객체로 생성
        String str2 = new String(bytes, 6, 4); //74의 인덱스 위치, 4개
        System.out.println(str2);

    }
}
