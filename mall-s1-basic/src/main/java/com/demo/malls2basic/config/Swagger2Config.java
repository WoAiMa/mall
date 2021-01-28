package com.demo.malls2basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2 API文档配置
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包下Controller生成swagger
                .apis(RequestHandlerSelectors.basePackage("com.demo.malls1basic.controller"))
//              为类生成API文档
//                .apis(RequestHandlerSelectors.withClassAnnotation("Api。class"))
//              为方法生成API文档
//                .apis(RequestHandlerSelectors.withMethodAnnotation("Api.class"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger-UI 演示")
                .description("mall learning")
                .contact("maq")
                .version("1.0")
                . build();
    }
}
