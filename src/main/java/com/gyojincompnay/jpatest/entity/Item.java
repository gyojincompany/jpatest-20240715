package com.gyojincompnay.jpatest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity //entity 클래스로 지정
@Table(name = "item") //실제 데이터베이스의 테이블이름
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {

    @Id
    @Column(name = "item_id") //필드이름->item_id
    @GeneratedValue(strategy = GenerationType.AUTO) //mysql 기본키 전략:자동으로 1번부터 번호생성
    private Long id; //상품코드

    @Column(length = 50, nullable = false)
    private String itemNm; //상품명

    @Column(name = "price", nullable = false)
    private int price; //가격

    @Column(nullable = false)
    private int stockNumber; //재고수량

    @Column(nullable = false)
    private String itemDetail; //상품상세설명


    private LocalDateTime regTime; //상품등록시간
    private LocalDateTime updateTime; //상품수정시간


}
