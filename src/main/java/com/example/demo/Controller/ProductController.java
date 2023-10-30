package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MongoModel.Product;
import com.example.demo.MongoModel.ProductVariation;
import com.example.demo.Repository.ProductRepo;
import com.example.demo.Repository.ProductVariationRepo;

@RestController
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductVariationRepo productVariationRepo;

    @RequestMapping("/pdp")
    public String getPDP(@RequestParam Map<String, String> allRequestParams, ModelMap model) {
        String pid = allRequestParams.get("pid");

        if (pid == null) {
            return "nullPid";
        }

        Product masterProduct = productRepo.findProductById(pid);

        if (masterProduct == null) {
            ProductVariation variationProduct = productVariationRepo.findProductVariationById(pid);

            if (variationProduct == null) {
                //code to show error page/no product found page
                return "null";
            }

            return variationProduct.getName();
        }

        return masterProduct.getName();
    }
}
