package com.startech.person.service.concretes.stock;

import com.startech.person.core.utils.mappers.ModelMapperService;
import com.startech.person.model.stock.Stock;
import com.startech.person.repository.stock.StockRepository;
import com.startech.person.service.abstracts.stock.StockService;
import com.startech.person.service.dto.request.stock.create.CreateStockRequest;
import com.startech.person.service.dto.request.stock.update.UpdateStockRequest;
import com.startech.person.service.dto.response.stock.create.CreateStockResponse;
import com.startech.person.service.dto.response.stock.get.GetAllStocksResponse;
import com.startech.person.service.dto.response.stock.get.GetStockResponse;
import com.startech.person.service.dto.response.stock.update.UpdateStockResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StockManager implements StockService {

    private final StockRepository repository;
    private final ModelMapperService mapper;

    @Override
    public List<GetAllStocksResponse> getAll() {
        List<Stock> stocks=repository.findAll();
        return stocks.stream().map(brand->mapper.forResponse().map(brand,GetAllStocksResponse.class)).toList();
    }

    @Override
    public GetStockResponse getById(UUID id) {
        checkIfStockExist(id);
        Stock stock=repository.findById(id).orElseThrow();
        return mapper.forResponse().map(stock,GetStockResponse.class);
    }

    @Override
    public CreateStockResponse add(CreateStockRequest request) {
        Stock stock=mapper.forRequest().map(request,Stock.class);
        stock.setCreatedAt(new Date());
        stock.setUpdatedAt(new Date());
        stock.setTotalPrice(stock.getAmount()*stock.getUnitPrice());
        repository.save(stock);
        return mapper.forResponse().map(stock,CreateStockResponse.class);
    }

    @Override
    public UpdateStockResponse update(UUID id, UpdateStockRequest request) {
        checkIfStockExist(id);
        Stock stock=mapper.forRequest().map(request,Stock.class);
        stock.setId(id);
        stock.setCreatedAt(getById(id).getCreatedAt());
        stock.setUpdatedAt(new Date());
        repository.save(stock);
        return mapper.forResponse().map(stock,UpdateStockResponse.class);
    }



    @Override
    public void delete(UUID id) {
        checkIfStockExist(id);
        repository.deleteById(id);
    }
    private void checkIfStockExist(UUID id) {
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Couldn't found Stock: " + id.toString()));
    }
}
