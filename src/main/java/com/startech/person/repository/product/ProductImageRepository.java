package com.startech.person.repository.product;

import com.startech.person.model.product.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductImageRepository extends JpaRepository<ProductImage, UUID> {

    public List<ProductImage> findAllByProduct_Id(UUID productId);
    ProductImage getById(UUID id);
}
