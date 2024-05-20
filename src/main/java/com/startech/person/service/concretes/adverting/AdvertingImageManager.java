package com.startech.person.service.concretes.adverting;

import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.adverting.GeneralAdverting;
import com.startech.person.model.adverting.GeneralAdvertingImage;
import com.startech.person.repository.adverting.GeneralAdvertingImageRepository;
import com.startech.person.service.abstracts.adverting.AdvertingImageService;
import com.startech.person.service.dto.response.user.get.GetAdvertingImageDto;
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
public class AdvertingImageManager implements AdvertingImageService {

    private final GeneralAdvertingImageRepository repository;
    private final ModelMapperService mapper;

    public List<GeneralAdvertingImage> saveBatch(List<GeneralAdvertingImage> generalAdvertingImages) {
        return repository.saveAll(generalAdvertingImages);
    }

    @Override
    public List<GetAdvertingImageDto> add(UUID generalAdvertingId, List<MultipartFile> multipartFileList)
            throws IOException {
        GeneralAdverting generalAdverting = new GeneralAdverting(generalAdvertingId);
        List<GeneralAdvertingImage> generalAdvertingImageList = new ArrayList<>();
        for (MultipartFile file : multipartFileList) {
            try {
                String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                String filePath = "C:/Users/burak/OneDrive/Masaüstü/Resimler2/" + fileName;
                file.transferTo(new File(filePath));
                generalAdvertingImageList.add(new GeneralAdvertingImage(new Date(), new Date(), generalAdverting, filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<GeneralAdvertingImage> createdProductImageList = saveBatch(generalAdvertingImageList);
        return createdProductImageList.stream()
                .map(createdProductImage -> mapper.forResponse().map(createdProductImage, GetAdvertingImageDto.class))
                .toList();
    }

    @Override
    public List<GetAdvertingImageDto> getAllByProductId(UUID productId) {
        List<GeneralAdvertingImage> productImageList = repository.findAllByGeneralAdverting_Id(productId);
        return productImageList.stream()
                .map(productImage -> mapper.forResponse().map(productImage, GetAdvertingImageDto.class))
                .toList();
    }

    @Override
    public void delete(UUID id) {
        checkIfProductImageExist(id);
        repository.deleteById(id);
    }

    private void checkIfProductImageExist(UUID id) {
        repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Couldn't found Product: " + id.toString()));
    }

}
