package com.startech.person.controller.stock;



import com.startech.person.service.abstracts.stock.StockService;
import com.startech.person.service.dto.request.stock.create.CreateStockRequest;
import com.startech.person.service.dto.request.stock.update.UpdateStockRequest;
import com.startech.person.service.dto.response.stock.create.CreateStockResponse;
import com.startech.person.service.dto.response.stock.get.GetAllStocksResponse;
import com.startech.person.service.dto.response.stock.get.GetStockResponse;
import com.startech.person.service.dto.response.stock.update.UpdateStockResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/stock")
public class StockController {
    private StockService service;

    @GetMapping("/getAll")
    public List<GetAllStocksResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetStockResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<GetStockResponse>(service.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CreateStockResponse> save(@RequestBody CreateStockRequest request) {
        return new ResponseEntity<CreateStockResponse>(service.add(request), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateStockResponse> updateStock(@PathVariable UUID id, @RequestBody UpdateStockRequest request) {
        return new ResponseEntity<UpdateStockResponse>(service.update(id, request), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
