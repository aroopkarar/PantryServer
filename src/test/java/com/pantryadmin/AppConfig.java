package com.pantryadmin;

import com.pantryadmin.Service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public ProductService getProductService() {
        return new ProductService();
    }

    /*@Bean
    public ProductRepository getProductRepository() {
        return ProductRepository();
    }*/
}
