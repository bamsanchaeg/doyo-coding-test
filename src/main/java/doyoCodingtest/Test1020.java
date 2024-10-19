package doyoCodingtest;




public class Test1020 {


    //Key 클래스틑 number 라는 정수형 필드를 가지고 있다. 이 필드는 Key 객체의 고유 값을 나타낸다.
    public class Key{

        public int number;

        //Key 객체가 생성될 때, number 값을 생성자에서 초기화 한다. 새로운 Key 객체는 이 number 값을 기반으로 생성된다.
        public Key(int number){
            this.number = number;
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
                Key compareKey = (Key) obj;

                //두 객체의 number 값을 비교한다. 만약 두 값이 같다면, true를 반환하여 두 객체가 같음을 나타낸다.
                if(this.number == compareKey.number){
                    return true;
                }
            }

            return false;
        }

    }
    


}


