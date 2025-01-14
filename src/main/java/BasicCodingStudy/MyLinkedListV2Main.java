package BasicCodingStudy;

public class MyLinkedListV2Main {

    //void add(int index, Object e)
    //특정 위치에 데이터를 추가한다.
    //내부에서 노드도 함께 추가된다
    //Object Remove(int index)
    //특정 위치에 있는 데이터를 제거한다
    //내부에서 노드도 함께 제거된다
    public static void main(String[] args) {

        MyLinkedListV2 list = new MyLinkedListV2();
        //마지막에 추가

        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);

        //첫번쨰 항목에 추가, 삭제
        System.out.println("첫 번쨰 항목에 추가");
        list.add(0,"d");
        System.out.println(list);

        System.out.println("첫번째 항목 삭제");
        list.remove(0);
        System.out.println(list);

        //중간 항목에 추가, 삭제
        System.out.println("중간 항목에 추가");
        list.add(1,"e");
        System.out.println(list);

        System.out.println("중간 항목 삭제");
        list.remove(1);
        System.out.println(list);

    }
}
