package com.startech.person.controller.stock.parameter;


import com.startech.person.service.abstracts.stock.parameter.StockCategoryService;
import com.startech.person.service.dto.request.stock.create.CreateParameterRequest;
import com.startech.person.service.dto.request.stock.update.UpdateParameterRequest;
import com.startech.person.service.dto.response.stock.create.CreateParameterResponse;
import com.startech.person.service.dto.response.stock.get.GetAllParametersResponse;
import com.startech.person.service.dto.response.stock.get.GetParameterResponse;
import com.startech.person.service.dto.response.stock.update.UpdateParameterResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@AllArgsConstructor
@RequestMapping("/stockCategory")
public class StockCategoryController {

    private StockCategoryService service;

    @GetMapping("/getAll")
    public List<GetAllParametersResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/getAllByActive")
    public List<GetAllParametersResponse> getAllByActiveTrue(){
        return service.getAllByActiveTrue();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetParameterResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<GetParameterResponse>(service.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CreateParameterResponse> save(@RequestBody CreateParameterRequest request) {
        return new ResponseEntity<CreateParameterResponse>(service.add(request), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateParameterResponse> update(@PathVariable UUID id, @RequestBody UpdateParameterRequest request) {
        return new ResponseEntity<UpdateParameterResponse>(service.update(id, request), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
