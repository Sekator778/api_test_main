//package com.example.api.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swaagger2.annotations.EnableSwagger2;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
///**
// * Created by dn070578noi on 02.09.23.
// */
//@EnableSwagger2
//@Configuration
//public class Swagger2Config {
//
// @Bean
// public Docket productApi() {
//  return new Docket(DocumentationType.SWAGGER_2)
//          .select()
//          .apis(RequestHandlerSelectors.basePackage("com.demo.resource"))
//          .paths(regex("/v1.*"))
//          .build();
// }
//}