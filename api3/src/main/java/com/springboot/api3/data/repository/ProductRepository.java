package com.springboot.api3.data.repository;

import com.springboot.api3.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //JpaRepository를 상속 받기 위해서는 엔티티와 기본값 타입이 지정되어야 한다.



}
