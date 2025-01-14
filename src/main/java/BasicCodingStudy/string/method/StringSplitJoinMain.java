package BasicCodingStudy.string.method;

public class StringSplitJoinMain {

    public static void main(String[] args) {
        String str = " Apple, Banana, Orange";

        //split
        String[] splitStr = str.split(",");
        for(String s : splitStr){
            System.out.println(s);
        }

        //join()
        String joinStr = "";

        //문자열 배열 연결
        String result = String.join("-", splitStr);
        System.out.println("result =" + result);


    }
}
