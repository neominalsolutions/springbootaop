package com.akbank.springbootaop.services;

import org.springframework.stereotype.Service;

import com.akbank.springbootaop.aspects.Log;
import com.akbank.springbootaop.models.Product;

@Service
public class ProductService {

  @Log // çağıracağımız aspect için anotasyonu yazdık
  public void saveProduct(String name, String description) {

    // AfterThrowing'i çalıştırdık
    // throw new Error("Hata");
    name = "can";
    description = "canan";
    System.out.println("save product işlemi");
    var p = new Product();
    p.Name = "ProductName";

  }

}
