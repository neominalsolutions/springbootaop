package com.akbank.springbootaop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.akbank.springbootaop.services.ProductService;

// EnableAspectJAutoProxy aspect olarak işaretlenmiş sınıfların tetiklenmesini sağladık
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringbootaopApplication {

	public static void main(String[] args) {

		var ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh(); // register sonrası context reflesh ile register edilen beanlari spring ioc
										// sürecine dahil ettik

		var productService = ctx.getBean(ProductService.class);

	

		var p = new ProductService();
		var result = productService.saveProduct("product-1", "ürün ekleme", 20);

		System.out.println(result);

		// productService.saveProduct("product-1", "ürün ekleme");

		// SpringApplication.run(SpringbootaopApplication.class, args);
	}

}
