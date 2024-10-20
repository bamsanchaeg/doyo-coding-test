package BasicCodingStudy;


import java.lang.reflect.Member;
import java.util.HashMap;

public class JavaExam03 {


    //Key 클래스틑 number 라는 정수형 필드를 가지고 있다. 이 필드는 Key 객체의 고유 값을 나타낸다.
    public static class Key{

        public String id;

        //Key 객체가 생성될 때, number 값을 생성자에서 초기화 한다. 새로운 Key 객체는 이 number 값을 기반으로 생성된다.
        public Key(String id){
            this.id = id;
        }


        //equals() 메서드(오버라이딩)
        @Override
        public boolean equals(Object obj){

            //기본 기본 equals()는 참조 비교를 하지만,
            //여기서는 Key 객체의 number 값이 같으면 두 객체를 동일하다고 간주하도록 오버라이딩하고 있다.

            /**
             * 	입력 객체가 Key 인스턴스인지 확인:
             * 	if (obj instanceof Key)로 입력 객체 obj가 Key 타입인지 확인
             * 	만약 Key 타입이 아니면 false를 반환합니다.
             * */

            if(obj instanceof Key){
                //입력 객체가 Key 타입인 것이 확인되면, Key compareKey = (Key) obj;로 객체를 Key 타입으로 캐스팅한다.
                Key member = (Key) obj;
                //아이디가 동일한 문자열일 경우 같은 해시 코드를 리턴함
                if(id.equals(member.id)){
                    return true;
                }
            }

            return false;
        }

        @Override
        public int hashCode(){
            return id.hashCode();
        }

    }

    /* 이 코드에서 HashMap에 Key 객체를 저장하고 다시 읽어올 때, 값이 null로 반환되는 이유는
     * HashMap의 동작 원리와 Key 클래스에서 equals() 메서드만 오버라이드했기 때문이다.
     *
     * <HashMap의 동작 원리>
     *
     * 	1.키와 해시코드:
     * 	 HashMap은 내부적으로 키의 해시코드를 사용하여 객체를 저장하고 검색한디. 키를 저장할 때, hashCode() 메서드를 호출하여 해당 키의 해시코드를 계산하고, 이 해시코드를 기반으로 저장 위치(버킷)를 결정한다.
     * 	 따라서, 동일한 값이 저장된 키는 해시코드가 같아야 한다.
     *
     * 	2.equals() 메서드:
     * 	 equals() 메서드는 두 객체가 같은지를 비교하는데 사용된다.
     * 	 해시코드가 같은 객체들에 대해서만 equals() 메서드가 호출되어 실제 값이 같은지를 비교한다.
     *
     * 문제의 원인
     *
     * 	Key 클래스에서 equals() 메서드는 오버라이드되었지만, hashCode() 메서드는 오버라이드되지 않았다.
     * 	Object 클래스의 기본 hashCode() 메서드는 객체의 메모리 주소를 기준으로 해시코드를 반환하기 때문에,
     * 	두 개의 서로 다른 Key 객체(예: new Key(1)와 new Key(1))는 서로 같은 값을 가지고 있지만, 서로 다른 해시코드를 가진다.
     *
     */


    public static void main(String[] args) {

        //Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
        HashMap<Key, String> hashMap = new HashMap<Key, String>();

        //식별키 new Key(1)로 홍길동을 저장
        hashMap.put(new Key("1"), "김자바");

        //식별키 new Key(1)로 홍길동을 읽어옴
        String value = hashMap.get(new Key("1"));

        //해시코드의 리턴값이 int 여서 값이 null 이 리턴됨
        System.out.println(value);


    }



}


