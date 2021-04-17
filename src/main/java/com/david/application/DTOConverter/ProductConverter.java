package com.david.application.DTOConverter;

import com.david.application.DTO.ProductDTO;
import com.david.application.entity.Product;
import com.david.application.util.DTOConverter;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter implements DTOConverter<Product, ProductDTO> {

    @Override
    public Product fromDTO(ProductDTO DTO) {
        Product product = new Product();
        product.setPrice(DTO.getPrice());
        product.setName(DTO.getName());
        product.setSku(DTO.getSku());

        return product;
    }

    @Override
    public ProductDTO fromEntity(Product entity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setPrice(entity.getPrice());
        productDTO.setName(entity.getName());
        productDTO.setSku(entity.getSku());

        return productDTO;
    }
}
