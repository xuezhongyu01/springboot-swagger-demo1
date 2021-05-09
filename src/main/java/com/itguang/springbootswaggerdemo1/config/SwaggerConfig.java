package com.itguang.springbootswaggerdemo1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itguang.springbootswaggerdemo1.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private String getAdminDescrpiton() {
        return "采用rest协议, 要授权的url以'/admin/auth/'开头。不用token也能访问的url以'/admin/unAuth/'为开头。  ";
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful API")
                .description(getAdminDescrpiton())
                .termsOfServiceUrl("http://blog.csdn.net/itguangit")
                .contact("niba")
                .version("1.0")
                .build();
    }

}
