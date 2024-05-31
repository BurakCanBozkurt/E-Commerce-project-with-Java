package com.startech.person.controller.product.campaign;


import com.startech.person.service.abstracts.product.campaign.CampaignService;
import com.startech.person.service.dto.request.product.create.campaign.CreateCampaignRequest;
import com.startech.person.service.dto.request.product.update.campaign.UpdateCampaignRequest;
import com.startech.person.service.dto.response.product.create.campaign.CreateCampaignResponse;
import com.startech.person.service.dto.response.product.get.campaign.GetAllCampaignResponse;
import com.startech.person.service.dto.response.product.get.campaign.GetCampaignResponse;
import com.startech.person.service.dto.response.product.update.campaign.UpdateCampaignResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("campaign")
public class CampaignController {
    private CampaignService service;
    @GetMapping("/getAll")
    public List<GetAllCampaignResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/getAllByActiveTrue")
    public List<GetAllCampaignResponse> getAllByActiveTrue(){
        return service.getAllByActiveTrue();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetCampaignResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<GetCampaignResponse>(service.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CreateCampaignResponse> save(@RequestBody CreateCampaignRequest request) {
        return new ResponseEntity<CreateCampaignResponse>(service.add(request), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UpdateCampaignResponse> update(@PathVariable UUID id, @RequestBody UpdateCampaignRequest request) {
        return new ResponseEntity<UpdateCampaignResponse>(service.update(id, request), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
