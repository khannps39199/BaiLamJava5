package poly.edu.controller.Lab6;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import poly.edu.Entity.Lab6.*;
import poly.edu.Reposiitory.*;

@Controller
@RequestMapping("/categories") 
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private ProductRepository productRepo;

    // Lấy danh sách danh mục
    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> allCate = categoryRepo.findAll();
        model.addAttribute("categories", allCate);
        
        return "Lab6/CategoriesCRUD.html";
    } 
    @GetMapping("/tonkho")
    public String tonkho(Model model) {
        List<report> allTonkho = productRepo.getTonKho();
        System.out.println( allTonkho.get(0).getGroup());
        model.addAttribute("tonkho", allTonkho);
        return "Lab6/TonKho.html";
    }


    
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category category, Model model) {
        if (category.getCreatedAt() == null) {
            category.setCreatedAt(new Timestamp(System.currentTimeMillis())); // Gán thời gian tạo
        }
        categoryRepo.save(category);
        return "redirect:/categories"; // Redirect để form trống sau khi thêm
    }

    // Chỉnh sửa danh mục (Hiển thị thông tin cần chỉnh sửa)
    @GetMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Integer id, Model model) {
        Category category = categoryRepo.findById(id).orElse(null);
        if (category == null) {
            return "redirect:/categories"; // Nếu không tìm thấy, quay về danh sách danh mục
        }
        model.addAttribute("category", category);
        model.addAttribute("categories", categoryRepo.findAll());
        return "Lab6/CategoriesCRUD.html";
    }

    // Xóa danh mục
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        categoryRepo.deleteById(id);
        return "redirect:/categories"; // Quay lại danh sách sau khi xóa
    }
}
