package com.mdt.orderTrack.controller;

import com.mdt.orderTrack.dto.category.CategoryRequestDto;
import com.mdt.orderTrack.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @PostMapping("/")
    public void createCategory(@RequestBody CategoryRequestDto categoryRequestDto){
        categoryService.insert(categoryRequestDto);
    }
}
