package alejogz.com.libraryapi.controller;

import alejogz.com.libraryapi.model.Category;
import alejogz.com.libraryapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable String id){
        return categoryRepository.findById(id);
    }

    @PostMapping
    public Category newCategory(@RequestBody Category category){
        category.setId(UUID.randomUUID().toString());
        return categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable String id){
        categoryRepository.deleteById(id);
    }

}
