package uz.pdp.apelsin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.apelsin.dto.ApiResponse;
import uz.pdp.apelsin.dto.ProductDTO;
import uz.pdp.apelsin.entity.Category;
import uz.pdp.apelsin.entity.Product;
import uz.pdp.apelsin.repository.CategoryRepository;
import uz.pdp.apelsin.repository.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    final CategoryRepository categoryRepository;
    final ProductRepository productRepository;

    public ApiResponse add(ProductDTO productDTO) {
        Optional<Category> optionalCategory = categoryRepository.findAllByIdAndActiveTrue(productDTO.getCategoryId());
        if (optionalCategory.isEmpty()) return new ApiResponse("ProductService.add: Category Not Found", false);

        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCategory(optionalCategory.get());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setPhoto(productDTO.getPhoto());

        productRepository.save(product);
        return new ApiResponse("Saved!", true);
    }

    public ApiResponse edit(Integer id, ProductDTO productDTO) {
        Optional<Category> optionalCategory = categoryRepository.findAllByIdAndActiveTrue(productDTO.getCategoryId());
        Optional<Product> optionalProduct = productRepository.findAllByIdAndActiveTrue(id);
        if (optionalCategory.isEmpty() | optionalProduct.isEmpty()) return new ApiResponse(
                "ProductService.add: Product or Category Not Found",false);

        Product product = optionalProduct.get();
        product.setName(productDTO.getName());
        product.setCategory(optionalCategory.get());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setPhoto(productDTO.getPhoto());

        productRepository.save(product);
        return new ApiResponse("Saved!", true);
    }
}
