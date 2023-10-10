package com.akbank.springbootaop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.akbank.springbootaop.aspects.LogAspect;
import com.akbank.springbootaop.services.ProductService;

@Configuration
@ComponentScan(basePackages = "com.akbank.springbootaop")
public class AppConfig {

  // product Service bean tanımı
  @Bean()
  ProductService productService() {
    return new ProductService();
  }

  // bu aspect sınıfının tetiklenebilmesi için bean olarak tanımladık.
  @Bean()
  LogAspect logAspect() {
    return new LogAspect();
  }

}
