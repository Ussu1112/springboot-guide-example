package com.springboot.api3.data.dao.impl;

import com.springboot.api3.data.dao.ProductDAO;
import com.springboot.api3.data.entity.Product;
import com.springboot.api3.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class ProductDAOImpl implements ProductDAO {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public Product insertProduct(Product product){
        Product saveProduct = productRepository.save(product);

        return saveProduct;
    }
    @Override
    public Product selectProduct(Long number){
        // EntityManager의 getReference()메서드를 호출하고 프락시객체를 리턴
        // 실제 쿼리는 프락시 객체를 통해 최초로 접근하는 시점에 실행
        // 데이터가 존재하지않을 때 EntityNotFoundException 발생
        Product selectedProduct = productRepository.getById(number);

        // EntityManager의 find() 메서드 실행
        // 영속성 컨텍스트의 캐시에서 값을 조회한 뒤 없으면 실제 디비에서 조회
        // 리턴 시 Optional 객체로 전달
        //Optional<Product> selectedProduct = productRepository.findById(number);

        return selectedProduct;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> selectedProduct = productRepository.findById(number);

        Product updateProduct;
        if (selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            product.setName(name);
            product.setUpdateAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }

        return updateProduct;
    }
    @Override
    public void deleteProduct(Long number) throws Exception{
        Optional<Product> selectedProduct = productRepository.findById(number);

        if(selectedProduct.isPresent()) {
            Product product = selectedProduct.get();

            productRepository.delete(product);
        } else {
            throw new Exception();
        }

    }


}
