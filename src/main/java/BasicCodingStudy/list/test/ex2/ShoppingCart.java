package BasicCodingStudy.list.test.ex2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public void disPlayItem() {
        System.out.println("장바구니 상품 출력");
        //루프가 상품을 출력하는 목적만 있는데 계산까지 들어간다면 유지보수가 떨어짐. 그래서 분리해라.
        for (Item item : items) {
            System.out.println("상품명 : " + item.getName() + ",합계 : " + item.getTotalPrice());
        }
        System.out.println("전체 가격 합 : " + calculateTotalPrice());
    }

    //윺지보수에 초점을 맞추기
    private int calculateTotalPrice() {
        //메서드로 뽑기 좋게
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }
}
