package com.example.demo;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import product.Product;
import product.ProductService;
import search.Search;
import search.SearchService;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/**
 * Main class
 */

@SpringBootApplication
@ImportResource({"classpath*:spring.xml"})
@ComponentScan({"mongo", "review", "product", "sequence", "search", "com.example.demo", "utility", "orderingLogic"})
public class DemoApplication {

    public static void main(String[] args) {
        final ApplicationContext applicationContext = SpringApplication.run(DemoApplication.class, args);
        applicationContext.getBeanDefinitionNames();
        System.out.println("Name of Product and Pincode");
        Scanner scn = new Scanner(System.in);
//        while(true){
//            System.out.println("Enter product details");
//            final String next = scn.next();
//            final String[] split = next.split(",");
//            Product p = new Product();
//            p.setVendor(split[0]);
//            p.setBrandName(split[1]);
//            p.setProductName(split[2]);
//            p.setColor(split[3]);
//            p.setRatings(Double.parseDouble(split[4]));
//            p.setPrice(Double.parseDouble(split[5]));
//            System.out.println("Enter product pincodes");
//            final String pincodes = scn.next();
//            p.setDeliverablePinCodes(Lists.newArrayList(pincodes.split(",")));
//            applicationContext.getBean(ProductService.class).saveProduct(p);
//            System.out.println("product saved");
//        }
        String productName = scn.next();
        String pincode = scn.next();
        InputDTO inputDTO = new InputDTO(productName, pincode);
        final List<Product> orderedProduct = applicationContext.getBean(SearchService.class).searchProducts(inputDTO);
        List<Product> notDeliverableProducts = orderedProduct.stream().filter(product -> !product.getDeliverablePinCodes().contains(inputDTO.getPincode())).collect(Collectors.toList());
        System.out.println("\t\t\t\t Showing Results " + inputDTO.getProductName());
        for (Product product : orderedProduct) {
            if(product.getDeliverablePinCodes().contains(inputDTO.getPincode())) {
                System.out.printf("%20s \t %20s \t %.2f \t %.1f", product.getVendor(), product.getBrandName(), product.getPrice(), product.getRatings());
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Products not available in your area");
        for (Product product : notDeliverableProducts) {
            System.out.printf("%20s \t %20s \t %.2f \t %.1f", product.getVendor(), product.getBrandName(), product.getPrice(), product.getRatings());
            System.out.println();
        }
    }
}



