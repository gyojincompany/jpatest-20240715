package com.gyojincompnay.jpatest;

import com.gyojincompnay.jpatest.entity.Item;
import com.gyojincompnay.jpatest.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        for(int i=1;i<=10;i++) {
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000+i);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setStockNumber(100);
            item.setRegTime(LocalDateTime.now());//현재 시간으로 삽입
            item.setUpdateTime(LocalDateTime.now());

            Item savedItem = itemRepository.save(item); //DB에 insert문이 실행되는 것과 같은 기능 실행
            System.out.println(savedItem.toString());
        }
    }

    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest() {
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품");

        for(Item item:itemList) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("상품가격이 10,000원 이하 상품 조회 테스트")
    public void findByPriceLessThanEqualTest() {
        List<Item> itemList = itemRepository.findByPriceLessThanEqual(10000);

        for(Item item:itemList) {
            System.out.println(item.toString());
        }
    }

    @Test
    @DisplayName("상품명 또는 상품상세설명 조회 테스트")
    public void findByItemOrItemDetailTest() {
        List<Item> itemList = itemRepository.findByItemNmOrItemDetail("테스트 상품", "테스트 상품 상세 설명7");

        for(Item item:itemList) {
            System.out.println(item.toString());
        }
    }

}
