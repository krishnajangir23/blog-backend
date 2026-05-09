package com.krishna.blog.controllers;

import com.krishna.blog.domain.dtos.CategoryDto;
import com.krishna.blog.domain.entities.Category;
import com.krishna.blog.mappers.CategoryMapper;
import com.krishna.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        List<CategoryDto> categories = categoryService.listCategories()
                .stream().map(category -> categoryMapper.toDto(category))
                .toList();
        return ResponseEntity.ok(categories);
    }

}
