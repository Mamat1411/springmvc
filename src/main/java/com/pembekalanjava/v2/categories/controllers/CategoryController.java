package com.pembekalanjava.v2.categories.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pembekalanjava.v2.categories.dtos.responses.CategoryRespDto;
import com.pembekalanjava.v2.categories.entities.Category;
import com.pembekalanjava.v2.categories.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getAllCategories() {
        Map<String, Object> resultMap = new HashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        try {
            List<Category> categories = categoryService.getAllCategories();
            List<CategoryRespDto> categoryRespDtos = categories.stream()
                                                    .map(category -> modelMapper
                                                    .map(category, CategoryRespDto.class))
                                                    .collect(Collectors.toList());
            resultMap.put("status", "200");
            resultMap.put("message", "Data Successfully Retrived");
            resultMap.put("data", categoryRespDtos);

            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("status", "500");
            resultMap.put("message", "Internal Server Error");

            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
