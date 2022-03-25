package uz.pdp.apelsin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.apelsin.dto.ApiResponse;
import uz.pdp.apelsin.entity.Category;
import uz.pdp.apelsin.entity.Category;
import uz.pdp.apelsin.repository.CategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    final CategoryRepository categoryRepository;

    public ApiResponse add(Category category) {
        Category save = new Category();
        save.setName(category.getName());
        categoryRepository.save(save);
        return new ApiResponse("Saved", true);
    }

    public ApiResponse edit(Integer id, Category category) {

        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) return new ApiResponse("Category Not found!", false);

        Category edited = byId.get();
        edited.setName(category.getName());
        categoryRepository.save(edited);

        return new ApiResponse("Edited", true);
    }
}
