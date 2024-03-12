package com.pembekalanjava.v2.categories.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.pembekalanjava.v2.categories.entities.Category;
import com.pembekalanjava.v2.categories.services.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/categories")
public class CategoryMvcController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getAllCategories(){
        ModelAndView view = new ModelAndView("categories/index");
        List<Category> categories = categoryService.getAllCategories();
        view.addObject("categoryData", categories);
        return view;
    }

    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("categories/form");
        Category category = new Category();
        view.addObject("category", category);
        return view;
    }
    
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Category category, BindingResult result) throws Exception {
        if (!result.hasErrors()) {
            try {
                categoryService.saveCategory(category);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ModelAndView("redirect:/categories");
    }
    
}
