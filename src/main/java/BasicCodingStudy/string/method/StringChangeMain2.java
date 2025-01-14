package BasicCodingStudy.string.method;

public class StringChangeMain2 {

    public static void main(String[] args) {
        String strWithSpace = "    Java Programming";

        System.out.println("소문자로 변환 : " + strWithSpace.toLowerCase());
        System.out.println("대문자로 변환 : " + strWithSpace.toUpperCase());

        System.out.println("공백 제거(trim)" + strWithSpace.trim()); //단순 whiteSpace제거
        System.out.println("공백 제거(strip):" + strWithSpace.strip() + "'"); //유니코드 공백까지 제거
        System.out.println("앞 공백 제거(strip):" + strWithSpace.stripLeading() + "'");
        System.out.println("뒤 공백 제거(strip):" + strWithSpace.stripTrailing() + "'");
    }
}
