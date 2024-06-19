package com.ryjtoh.inventory_service.controller;

import com.ryjtoh.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // Create a component (bean) that is a controller
@RequestMapping("/api/inventory") // This allows urls with pattern /api/inventory to be sent to this class
@RequiredArgsConstructor // this creates an constructor for the required argument aka the final or Nonnull variables,
                        // and in this cases promotes the dependency injection of inventoryService
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}") // Denotes GET request
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skuCode) { // @PathVariable("sku-code") makes the method parameter "skuCode" equal to the value in the get mapping path above
        return inventoryService.isInStock(skuCode);
    }

}
