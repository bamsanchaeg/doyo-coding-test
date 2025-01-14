package BasicCodingStudy.string.builder;

public class LoopStringMain {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        String result = "";
        for(int i = 0; i<100000; i++){
            sb.append("Hello Java");
            //result += "Hello Java";

        }
        long endTime = System.currentTimeMillis();
        String sbResult = sb.toString();
        System.out.println("result = " + sbResult);
        System.out.println("time = " + (endTime - startTime));
    }
}
