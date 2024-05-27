package com.startech.person.controller.adverting;

import com.startech.person.service.abstracts.adverting.AdvertingImageService;
import com.startech.person.service.dto.response.user.get.GetAdvertingImageDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("advertingImage")
public class AdvertingImageController {

    private AdvertingImageService service;

    @GetMapping("/getAllByAdvertingId")
    public ResponseEntity<List<GetAdvertingImageDto>> getAllByProductId(@RequestParam("generalAdvertingId") UUID productId) {
        return new ResponseEntity<List<GetAdvertingImageDto>>(service.getAllByProductId(productId), HttpStatus.CREATED);
    }

    @PostMapping("")
    public ResponseEntity<List<GetAdvertingImageDto>> add(@RequestParam("image") List<MultipartFile> imageList,
                                                     @RequestParam("generalAdvertingId") UUID productId) throws IOException {
        return new ResponseEntity<List<GetAdvertingImageDto>>(service.add(productId, imageList),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}