package com.startech.person.service.abstracts.adverting;

import com.startech.person.service.dto.response.user.get.GetAdvertingImageDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface AdvertingImageService {

    List<GetAdvertingImageDto> getAllByProductId(UUID productId);

    List<GetAdvertingImageDto> add(UUID productId, List<MultipartFile> multipartFileList) throws IOException;

    void delete(UUID id);
}
