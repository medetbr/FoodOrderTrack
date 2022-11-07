package com.mdt.orderTrack.service;

import com.mdt.orderTrack.dto.category.CategoryRequestDto;
import com.mdt.orderTrack.entity.Category;
import com.mdt.orderTrack.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public void insert(CategoryRequestDto categoryRequestDto) {
        Category category = createNewCategory(categoryRequestDto);
        categoryRepository.save(category);
    }
    private static Category createNewCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        category.setCategoryCode(UUID.randomUUID().toString().split("-")[0]);
        return category;
    }
    public Category findByCategoryCode(String categoryCode){
        return categoryRepository.findByCategoryCode(categoryCode);
    }
}
