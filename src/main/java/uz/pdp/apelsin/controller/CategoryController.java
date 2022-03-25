package uz.pdp.apelsin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.apelsin.dto.ApiResponse;
import uz.pdp.apelsin.entity.Category;
import uz.pdp.apelsin.repository.CategoryRepository;
import uz.pdp.apelsin.repository.CustomerRepository;
import uz.pdp.apelsin.service.CategoryService;
import uz.pdp.apelsin.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController {

    final CategoryRepository categoryRepository;
    final CategoryService categoryService;

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Category> categories = categoryRepository.findAllByActiveTrue();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        return ResponseEntity.status(optionalCategory.isEmpty() ?
                HttpStatus.NOT_FOUND : HttpStatus.OK).body(optionalCategory.orElse(new Category()));
    }

    @PostMapping
    public HttpEntity<?> add(@RequestBody Category category) {
        ApiResponse response = categoryService.add(category);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody Category category) {
        ApiResponse response = categoryService.edit(id, category);
        return ResponseEntity.status(response.isSuccess() ? 200 : 409).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) return ResponseEntity.status(404).body("Category Not Found!");
        Category category = byId.get();
        category.setActive(false);
        categoryRepository.save(category);
        return ResponseEntity.ok().body("Deleted!");
    }

}
