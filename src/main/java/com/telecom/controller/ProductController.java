package com.telecom.controller;

import com.telecom.model.Product;
import com.telecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller

@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class ProductController {
    @Autowired
    private ProductRepository repo;

    @GetMapping("/products")
    public String listAll(Model model) {
        List<Product> listProducts = repo.findAll();
        model.addAttribute("listProducts", listProducts);
        return "products";
    }
        @PostMapping(path="/add") // Map ONLY POST Requests
        public @ResponseBody
        String addNewProduct (@RequestParam String name
                , @RequestParam double price) {
            // @ResponseBody means the returned String is the response, not a view name
            // @RequestParam means it is a parameter from the GET or POST request

            Product n = new Product();
            n.setName(name);
            n.setPrice(price);
            repo.save(n);
            return "Saved";
        }

    }
