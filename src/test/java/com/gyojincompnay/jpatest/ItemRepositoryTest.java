package com.gyojincompnay.jpatest;

import com.gyojincompnay.jpatest.entity.Item;
import com.gyojincompnay.jpatest.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void createItemTest() {
        Item item = new Item();
        item.setItemNm("테스트 상품");
        item.setPrice(10000);
        item.setItemDetail("테스트 상품 상세 설명");
        item.setStockNumber(100);
        item.setRegTime(LocalDateTime.now());//현재 시간으로 삽입
        item.setUpdateTime(LocalDateTime.now());

        Item savedItem = itemRepository.save(item); //DB에 insert문이 실행되는 것과 같은 기능 실행
        System.out.println(savedItem.toString());

    }

}
