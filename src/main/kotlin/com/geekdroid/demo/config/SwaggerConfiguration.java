package com.geekdroid.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private final ServletContext context;

    @Autowired
    public SwaggerConfiguration(ServletContext context) {
        this.context = context;
    }

    @Bean
    public Docket createRestApi() {
        return new Docket((DocumentationType.SWAGGER_2))
                //修改BASE_URL显示
                .pathProvider(new RelativePathProvider(context) {
                    @Override
                    public String getApplicationBasePath() {
                        return "www.mydomain.com/";
                    }
                })
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.geekdroid"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot 中使用Swagger构建Restful APIs")
                .description("rest api文档构建利器")
                .contact(new Contact("James", "", "James@163.com"))
                .version("1.0")
                .build();
    }
}
