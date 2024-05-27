package com.startech.person.controller.adverting;

import com.startech.person.service.abstracts.adverting.GeneralAdvertingService;
import com.startech.person.service.dto.request.user.create.CreateGeneralAdvertingRequest;
import com.startech.person.service.dto.request.user.update.UpdateGeneralAdvertingRequest;
import com.startech.person.service.dto.response.user.create.CreateGeneralAdvertingResponse;
import com.startech.person.service.dto.response.user.get.GetGeneralAdvertingResponse;
import com.startech.person.service.dto.response.user.update.UpdateGeneralAdvertingResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("generalAdverting")
public class GeneralAdvertingController {
    private GeneralAdvertingService service;
    @GetMapping("/getAll")
    public List<GetGeneralAdvertingResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetGeneralAdvertingResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<GetGeneralAdvertingResponse>(service.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CreateGeneralAdvertingResponse> save(@RequestBody CreateGeneralAdvertingRequest request) {
        return new ResponseEntity<CreateGeneralAdvertingResponse>(service.add(request), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateGeneralAdvertingResponse> update(@PathVariable UUID id, @RequestBody UpdateGeneralAdvertingRequest request) {
        return new ResponseEntity<UpdateGeneralAdvertingResponse>(service.update(id, request), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
