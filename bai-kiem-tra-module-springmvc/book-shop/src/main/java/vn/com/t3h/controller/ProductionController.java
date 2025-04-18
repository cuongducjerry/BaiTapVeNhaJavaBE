package vn.com.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import vn.com.t3h.model.ProductDTO;
import vn.com.t3h.service.ProductService;

import java.util.List;

@Controller
public class ProductionController {

    private ProductService productService;

    public ProductionController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    public String products(Model model) {
        List<ProductDTO> productDTOS = productService.getProducts();
        model.addAttribute("products", productDTOS);
        return "products";
    }

}
