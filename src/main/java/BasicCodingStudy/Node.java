package BasicCodingStudy;

//Objects는 Java의 표준 라이브러리 클래스 (java.util.Objects)인데,
//이 타입은 객체 타입을 나타내는 것이 아니라 null 체크 등의 유틸리티 메서드를 제공하는 클래스입니다

public class Node {

    Object item;
    Node next;

    public Node(Object item){
        this.item = item;
    }

    //IDE 생성 toString()
//    @Override
//    public String toString(){
//        return "Node{" +
//                "item=" + item +
//                ", next=" + next +
//                '}';
//    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();  // StringBuilder 객체를 생성하여 문자열을 효율적으로 조립하기 시작
        Node x = this;  // 현재 노드(객체)를 가리키는 참조 변수 x
        sb.append("[");  // 출력할 문자열의 시작에 '['를 추가

        while (x != null){  // 현재 노드가 null이 아닐 동안(즉, 리스트의 끝에 도달하지 않았을 때까지) 반복
            sb.append(x.item);  // 현재 노드의 값을 출력할 문자열에 추가
            if (x.next != null){  // 만약 현재 노드의 다음 노드가 존재하면
                sb.append("->");  // 노드 사이를 나타내는 화살표("->")를 추가
            }
            x = x.next;  // 다음 노드로 이동
        }

        sb.append("]");  // 리스트 끝에 ']'를 추가하여 출력 형태를 완성
        return sb.toString();  // 완성된 문자열을 반환
    }
}
