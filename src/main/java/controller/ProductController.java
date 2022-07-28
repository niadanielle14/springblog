package controller;

import com.example.codeup.springblog.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String showAllProducts(Model vModel) {

        List<Product> productList = new ArrayList<>(Arrays.asList(
                new Product("Hammer", 1000),
                new Product("Broom", 2000),
                new Product("Mop", 500)
        ));

        // pass products to view
        vModel.addAttribute("products", productList);

        return "products/index";

    }




}
