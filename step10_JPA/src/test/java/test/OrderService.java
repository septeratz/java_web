package test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderService {

    public static void createOrder() {
        log.info("주문 생성 시작");
        log.debug("주문 파라미터 확인");
        log.warn("재고 부족 경고");
        log.error("주문 처리 실패");
    }
    
    public static void main(String[] args) {
		createOrder();
	}
}
