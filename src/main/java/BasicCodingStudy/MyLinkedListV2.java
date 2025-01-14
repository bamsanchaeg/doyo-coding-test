package BasicCodingStudy;


public class MyLinkedListV2 {

    private Node first;
    private int size = 0;

    public void add(Object e) {
        Node newNode = new Node(e);
        if (first == null) {
            first = newNode;
        } else {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    private Node getLastNode() {
        Node x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    //추가 코드
    public void add(int index, Object e) {
        Node newNode = new Node(e);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    public Object set(int index, Object element) {
        Node x = getNode(index);
        Object oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    public Object remove(int index) {
        Node removeNode = getNode(index);
        Object removedItem = removeNode.item;
        if (index == 0) {
            first = removeNode.next;
        } else {
            Node prev = getNode(index - 1);
            prev.next = removeNode.next;
        }

        removeNode.item = null;
        removeNode.next = null;
        size--;
        return removedItem;
    }

    public Object get(int index) {
        Node node = getNode(index);
        return node.item;
    }

    private Node getNode(int index) {
        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexOf(Object o) {
        int index = 0;
        for (Node x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListVer2{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    //유형이 다양한 제네릭으로 사용하겠다. 내부 중첩 클래스이다.
    private static class Node<E> {
        E item;
        Node next;

        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();  // StringBuilder 객체를 생성하여 문자열을 효율적으로 조립하기 시작
            Node<E> x = this;  // 현재 노드(객체)를 가리키는 참조 변수 x
            sb.append("[");  // 출력할 문자열의 시작에 '['를 추가

            while (x != null) {  // 현재 노드가 null이 아닐 동안(즉, 리스트의 끝에 도달하지 않았을 때까지) 반복
                sb.append(x.item);  // 현재 노드의 값을 출력할 문자열에 추가
                if (x.next != null) {  // 만약 현재 노드의 다음 노드가 존재하면
                    sb.append("->");  // 노드 사이를 나타내는 화살표("->")를 추가
                }
                x = x.next;  // 다음 노드로 이동
            }

            sb.append("]");  // 리스트 끝에 ']'를 추가하여 출력 형태를 완성
            return sb.toString();  // 완성된 문자열을 반환
        }
    }

}
