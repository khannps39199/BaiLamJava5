package poly.edu.controller.Lab6;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import poly.edu.Entity.Lab6.*;
import poly.edu.Reposiitory.*;

import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private CategoryRepository categoryRepo;
    @GetMapping("/admin/getproducts")
    public String getAllProducts(
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size, 
            Model model) {
        
    	Pageable pageable = PageRequest.of(page, size, Sort.by("productID").ascending());
        Page<Product> productPage = productRepo.findAll(pageable);
        model.addAttribute("products", productPage.getContent());  
        model.addAttribute("currentPage", productPage.getNumber());
        model.addAttribute("totalPages", productPage.getTotalPages()); 
        model.addAttribute("pageSize", size);
        model.addAttribute("totalItems", productPage.getTotalElements());
        model.addAttribute("hasNext", productPage.hasNext());
        model.addAttribute("hasPrevious", productPage.hasPrevious());
        model.addAttribute("product", new Product()); 
        model.addAttribute("categories", categoryRepo.findAll());

        model.addAttribute("url", "/products/filter");
        return "Lab6/ProductsCRUD.html";
    }	

    @GetMapping("/admin/product/sort")
    public String sortProducts(
            @RequestParam(defaultValue = "id") String field,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size, @RequestParam(required = false) Long categoryID,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            Model model) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(field).descending() : Sort.by(field).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Product> productPage = productRepo.findAll(pageable);
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", productPage.getNumber());
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("totalItems", productPage.getTotalElements());
        model.addAttribute("hasNext", productPage.hasNext());
        model.addAttribute("hasPrevious", productPage.hasPrevious());
        model.addAttribute("sortField", field);
        model.addAttribute("sortDirection", direction);
        model.addAttribute("CRUD","ProductsCRUD.html");
        model.addAttribute("url", "/admin/product/sort");
        model.addAttribute("sortBy", field);
        return "Lab6/ProductsCRUD.html";
    }
    
    @GetMapping("/products/filter")
    public String filterProducts(
            @RequestParam(defaultValue = "id") String field,
            @RequestParam(required = false) Long categoryID,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage;

        if (categoryID != null && minPrice != null && maxPrice != null) {
            productPage = productRepo.findByCategory_IdAndPriceBetween(categoryID, minPrice, maxPrice, pageable);
        } else if (minPrice != null && maxPrice != null) {
            productPage = productRepo.findProductsByPriceRangeNative(minPrice, maxPrice, pageable);
        } else if (categoryID != null) {
            productPage = productRepo.findByCategory_Id(categoryID, pageable);
        } else {
            productPage = productRepo.findAll(pageable);
        }		
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("Component", "Products.html");
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("categoryID", categoryID);
        model.addAttribute("url", "/products/filter");

        return "Lab6/ProductsCRUD.html";
    } @GetMapping("/products/filterByJPA")
    public String filterProductsByJPA(
            @RequestParam(defaultValue = "id") String field,
            @RequestParam(required = false) Long categoryID,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage;

        if (categoryID != null && minPrice != null && maxPrice != null) {
            productPage = productRepo.findByCategory_IdAndPriceBetween(categoryID, minPrice, maxPrice, pageable);
        } else if (minPrice != null && maxPrice != null) {
            productPage = productRepo.findByPriceBetween(minPrice, maxPrice, pageable);
        } else if (categoryID != null) {
            productPage = productRepo.findByCategory_Id(categoryID, pageable);
        } else {
            productPage = productRepo.findAll(pageable);
        }		
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("Component", "Products.html");
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("categoryID", categoryID);
        model.addAttribute("url", "/products/filter");

        return "Lab6/ProductsCRUD.html";
    }
    @GetMapping("/products/search")
    public String searchByKeyWork(
            @RequestParam(defaultValue = "id") String field,
            @RequestParam(required = false) String keywork,
            @RequestParam(required = false) Long categoryID,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            Model model) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage;

        if (categoryID != null && minPrice != null && maxPrice != null) {
            productPage = productRepo.findByCategory_IdAndPriceBetween(categoryID, minPrice, maxPrice, pageable);
        } else if (minPrice != null && maxPrice != null) {
            productPage = productRepo.findProductsByPriceRangeNative(minPrice, maxPrice, pageable);
        } else if (categoryID != null) {
            productPage = productRepo.findByCategory_Id(categoryID, pageable);
        } else if(keywork!=null){
            productPage = productRepo.findByKeywords(keywork,pageable);
        }	else {
            productPage = productRepo.findAll(pageable);
        }
        
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("Component", "Products.html");
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("keywork", keywork);
        model.addAttribute("categoryID", categoryID);
        model.addAttribute("url", "/products/filter");

        return "Lab6/ProductsCRUD.html";
    }@GetMapping("/products/searchByJPA")
    public String searchByKeyWorkByJPA(
            @RequestParam(defaultValue = "id") String field,
            @RequestParam(required = false) String keywork,
            @RequestParam(required = false) Long categoryID,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "8") int size,
            Model model) {
    	
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productPage;

        if (categoryID != null && minPrice != null && maxPrice != null) {
            productPage = productRepo.findByCategory_IdAndPriceBetween(categoryID, minPrice, maxPrice, pageable);
        } else if (minPrice != null && maxPrice != null) {
            productPage = productRepo.findProductsByPriceRangeNative(minPrice, maxPrice, pageable);
        } else if (categoryID != null) {
            productPage = productRepo.findByCategory_Id(categoryID, pageable);
        } else if(keywork!=null){
            productPage = productRepo.findAllByNameLike("%" + keywork + "%", pageable);

        }	else {
            productPage = productRepo.findAll(pageable);
        }
        
        model.addAttribute("products", productPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productPage.getTotalPages());
        model.addAttribute("pageSize", size);
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("Component", "Products.html");
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("keywork", keywork);
        model.addAttribute("categoryID", categoryID);
        model.addAttribute("url", "/products/filter");

        return "Lab6/ProductsCRUD.html";
    }
}
