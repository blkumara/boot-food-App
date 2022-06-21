package com.ty.bootfoodapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BootFoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootFoodAppApplication.class, args);

	}

	List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
	Contact contact = new Contact("kumara", "https://testyantra.com", "kumara@mail.com");

	ApiInfo apiInfo = new ApiInfo("TestYantra Food app", "API's to person all actions related to book a food order",
			"snapshoot-0.0.1", "https://testyantraglobal.com", contact, "www.ty.com", "terms and condition",
			vendorExtensions);

	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ty"))
				.build().apiInfo(apiInfo);
	}
}
