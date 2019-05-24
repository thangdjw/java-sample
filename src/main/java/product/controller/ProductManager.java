package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import product.model.ProductEntity;
import product.model.ProductFilter;
import product.service.ProductService;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/product")
public class ProductManager {
    @Autowired
    private ProductService productService;
    private Logger logger = Logger.getLogger(this.getClass().toString());

    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable("id") String id) {
        return productService.findById(id);
    }

    @GetMapping("/search/{identity}")
    public List<ProductEntity> getProductInfo(@PathVariable("identity") String name,
                                              ProductFilter filter) {
        return productService.findProduct(name, filter);
    }

    @PostMapping
    public boolean createProduct(ProductEntity product) {
        logger.info(product.toString());
        productService.addProduct(product);
        return true;
    }

    @PutMapping("/{id}")
    public boolean updateProduct(@PathVariable("id") int id, ProductEntity product) {
        product.setId(id);
        productService.updateProduct(product);
        return true;
    }
}
