package com.startech.person.service.abstracts.product;


import com.startech.person.service.dto.response.product.get.ProductImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface ProductImageService {

    List<ProductImageDto> getAllByProductId(UUID productId);

    List<ProductImageDto> add(UUID productId, List<MultipartFile> multipartFileList) throws IOException;

    void delete(UUID id);
}
