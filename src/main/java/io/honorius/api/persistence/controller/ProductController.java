package io.honorius.api.persistence.controller;

import io.honorius.api.domain.caseuse.CreateProductCaseUse;
import io.honorius.api.persistence.enity.ProductPersistence;
import io.honorius.api.persistence.mapper.ProductPersistenceMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final CreateProductCaseUse createProductCaseUse;
    private final ProductPersistenceMapper productPersistenceMapper;

    public ProductController(CreateProductCaseUse createProductCaseUse, ProductPersistenceMapper productPersistenceMapper) {
        this.createProductCaseUse = createProductCaseUse;
        this.productPersistenceMapper = productPersistenceMapper;
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody ProductPersistence productPersistence) {
        createProductCaseUse.createProduct(productPersistenceMapper.toDomain(productPersistence));
    }

}
