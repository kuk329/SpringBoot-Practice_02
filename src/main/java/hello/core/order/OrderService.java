package hello.core.order;

public interface OrderService {

    Order createOrder(Long memberId,String itemName,int itemPrice);
    // 주문 메서드에 주문자 id, 아이템 이름, 아이템 가격
}
