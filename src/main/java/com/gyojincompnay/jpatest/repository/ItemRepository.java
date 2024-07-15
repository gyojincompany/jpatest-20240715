package com.gyojincompnay.jpatest.repository;

import com.gyojincompnay.jpatest.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {


}
