package BasicCodingStudy.list;

public class MyLinkedList<E> implements MyList<E> {

    //E가 결정되면 다 결정됨
    private Node<E> first;
    private int size = 0;

    public void add(Object e) {
        Node<E> newNode = new Node(e);
        if (first == null) {
            first = newNode;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    private Node<E> getLastNode() {
        Node<E> x = first;
        while (x.next != null) {
            x = x.next;
        }
        return x;
    }

    //추가 코드
    @Override
    public void add(int index, E e) {
        Node<E> newNode = new Node(e);
        if (index == 0) {
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    @Override
    public E set(int index, E element) {
        Node<E> x = getNode(index);
        E oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        Node<E> removeNode = getNode(index);
        E removedItem = removeNode.item;
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

    @Override
    public E get(int index) {
        Node<E> node = getNode(index);
        return node.item;
    }


    private Node<E> getNode(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public int indexOf(E o) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
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
    //중첩 클래스는 특정 클래스 안에서만 사용될 때 주로 사용한다.
    //Node 클래스는 해당 클래스 안에서만 사용되고 외부에서는 사용할 이유가 없다.
    //중첩클래스를 사용하면 내부 클래스를 우선 사용한다.
    private static class Node<E> {
        E item;
        Node<E> next;

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
