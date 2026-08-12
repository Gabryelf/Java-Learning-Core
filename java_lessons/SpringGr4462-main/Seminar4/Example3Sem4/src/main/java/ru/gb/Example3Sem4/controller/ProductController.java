package ru.gb.Example3Sem4.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.Example3Sem4.model.Product;
import ru.gb.Example3Sem4.service.ProductService;

import java.util.List;

@Controller
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String viewProducts(Model model)
    {
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }

    @PostMapping("/products")
    public String addProduct(Product p,Model model)
    {
        productService.addProduct(p);
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }

}
