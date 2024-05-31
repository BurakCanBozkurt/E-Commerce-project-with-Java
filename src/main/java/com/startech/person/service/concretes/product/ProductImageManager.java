package com.startech.person.service.concretes.product;


import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.product.Product;
import com.startech.person.model.product.ProductImage;
import com.startech.person.repository.product.ProductImageRepository;
import com.startech.person.service.abstracts.product.ProductImageService;
import com.startech.person.service.dto.response.product.get.ProductImageDto;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductImageManager implements ProductImageService {

    private final ProductImageRepository repository;
    private final ModelMapperService mapper;

    public List<ProductImage> saveBatch(List<ProductImage> productImageList) {
        return repository.saveAll(productImageList);
    }

    @Override
    public List<ProductImageDto> add(UUID productId, List<MultipartFile> multipartFileList)
            throws IOException {
        Product product = new Product(productId);
        List<ProductImage> productImageList = new ArrayList<>();
        for (MultipartFile file : multipartFileList) {
            try {
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                String filePath = "src/main/resources/productimages/" + fileName;
                file.transferTo(new File(filePath));
                productImageList.add(new ProductImage(new Date(), new Date(), product, filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<ProductImage> createdProductImageList = saveBatch(productImageList);
        return getAllByProductForEntity(productId).stream()
                .map(createdProductImage -> mapper.forResponse().map(createdProductImage, ProductImageDto.class))
                .toList();
    }

    @Override
    public List<ProductImageDto> getAllByProductId(UUID productId) {
        List<ProductImage> productImageList = repository.findAllByProduct_Id(productId);
        return productImageList.stream()
                .map(productImage -> mapper.forResponse().map(productImage, ProductImageDto.class))
                .toList();
    }

    private List<ProductImage> getAllByProductForEntity(UUID productId) {
         return repository.findAllByProduct_Id(productId);
    }

    @Override
    public void delete(UUID id) {
        checkIfProductImageExist(id);
        String filePath =getById(id).getPath();
        File file=new File(filePath);
        file.delete();
        repository.deleteById(id);
    }
    private ProductImage getById(UUID id){
        return repository.getById(id);
    }

    private void checkIfProductImageExist(UUID id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't found Product: " + id.toString()));
    }

}
