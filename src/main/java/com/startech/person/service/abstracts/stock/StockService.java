package com.startech.person.service.abstracts.stock;



import com.startech.person.service.dto.request.stock.create.CreateStockRequest;
import com.startech.person.service.dto.request.stock.update.UpdateStockRequest;
import com.startech.person.service.dto.response.stock.create.CreateStockResponse;
import com.startech.person.service.dto.response.stock.get.GetAllStocksResponse;
import com.startech.person.service.dto.response.stock.get.GetStockResponse;
import com.startech.person.service.dto.response.stock.update.UpdateStockResponse;

import java.util.List;
import java.util.UUID;

public interface StockService {
    List<GetAllStocksResponse> getAll();
    GetStockResponse getById(UUID id);
    CreateStockResponse add(CreateStockRequest request);
    UpdateStockResponse update(UUID id, UpdateStockRequest request);
    void delete(UUID id);
}
