package com.example.apispringvuejs.Controllers;

import com.example.apispringvuejs.Dto.Dtocategory;
import com.example.apispringvuejs.Entity.CategoryHrAdministration;
import com.example.apispringvuejs.Service.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:3030")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<List<Dtocategory>> getAllCategory(){
        List<Dtocategory> dtocategories = this.categoryServiceImpl.getAllCategory();
        if(dtocategories != null){
            return ResponseEntity.ok(dtocategories);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dtocategories);
        }
    }
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity createCategory(@RequestBody() Dtocategory dtocategory){
      boolean isSuccess = this.categoryServiceImpl.createCategory(dtocategory);
      if(isSuccess){
          return ResponseEntity.ok(isSuccess);
      }else {
          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isSuccess);
      }
    }
    @PutMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity updateCategory(@PathVariable Long id,@RequestBody Dtocategory dtocategory){
        dtocategory.setId(id);
        boolean isSuccess = this.categoryServiceImpl.updateCategory(dtocategory);
        if(isSuccess){
            return ResponseEntity.ok(isSuccess);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isSuccess);
        }
    }
    @GetMapping("/categorie/{id}")
    @ResponseBody
    public ResponseEntity createCategory(@PathVariable Long id){
        Dtocategory dtocategory = this.categoryServiceImpl.getCategoryDtoById(id);
        if(dtocategory != null){
            return ResponseEntity.ok(dtocategory);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dtocategory);
        }
    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity deleteCategory(@PathVariable Long id){
        boolean isSuccess = this.categoryServiceImpl.deleteCategory(id);
        if(isSuccess){
            return ResponseEntity.ok(isSuccess);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isSuccess);
        }
    }
}
