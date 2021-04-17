package com.david.application.api;

import com.david.application.DTO.ProductDTO;
import com.david.application.DTOConverter.ProductConverter;
import com.david.application.entity.Product;
import com.david.application.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("products")
@CrossOrigin
public class ProductApi {

    @Autowired
    private ProductService productService;

    @Autowired
    ProductConverter productConverter;

    @GetMapping
    public List<ProductDTO> listAll() {
        return productConverter.fromEntity(productService.listAll());
    }

    @GetMapping("/{sku}")
    public ProductDTO get(@PathVariable String sku) {
        return productConverter.fromEntity(productService.getOne(sku));
    }

    @PostMapping
    public void add(@RequestBody ProductDTO productDTO) {
        productService.add(productConverter.fromDTO(productDTO));
    }

    @DeleteMapping("/{sku}")
    public void deleteBySku(@PathVariable String sku) {
        productService.deleteBySku(sku);
    }

    @PutMapping("/{sku}")
    public void modify(@PathVariable String sku,
                       @RequestBody ProductDTO productDTO) {
        productService.modify(sku, productConverter.fromDTO(productDTO));
    }
}