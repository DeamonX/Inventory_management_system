package hu.pte.inventory_management_system.controllers;

import hu.pte.inventory_management_system.models.Category;
import hu.pte.inventory_management_system.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/")
    public ResponseEntity<Category> addNewCategory(@RequestBody @Valid Category category){
        return new ResponseEntity<>(categoryService.addCategory(category), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Integer id){
        return categoryService.getCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategoryById(@PathVariable Integer id, @RequestBody @Valid Category category){
        return new ResponseEntity<>(categoryService.updateCategoryById(id, category), HttpStatus.OK);
    }
}
