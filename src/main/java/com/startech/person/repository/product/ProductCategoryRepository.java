package com.startech.person.repository.product;


import com.startech.person.model.product.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {

List<ProductCategory> findAllByActiveTrue();
}