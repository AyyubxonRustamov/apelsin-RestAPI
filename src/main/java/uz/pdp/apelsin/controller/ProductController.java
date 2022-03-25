package uz.pdp.apelsin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apelsin.dto.ApiResponse;
import uz.pdp.apelsin.dto.ProductDTO;
import uz.pdp.apelsin.entity.Product;
import uz.pdp.apelsin.repository.ProductRepository;
import uz.pdp.apelsin.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
@RequiredArgsConstructor
public class ProductController {

    final ProductRepository productRepository;
    final ProductService productService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Product> products = productRepository.findAllByActiveTrue();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return ResponseEntity.status(optionalProduct.isEmpty() ?
                HttpStatus.NOT_FOUND : HttpStatus.OK).body(optionalProduct.orElse(new Product()));
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody ProductDTO productDTO) {
        ApiResponse response = productService.add(productDTO);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        ApiResponse response = productService.edit(id, productDTO);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) return ResponseEntity.status(404).body("Product Not Found!");
        Product product = byId.get();
        product.setActive(false);
        productRepository.save(product);
        return ResponseEntity.ok().body("Deleted!");
    }

}
