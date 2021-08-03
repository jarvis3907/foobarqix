package com.wemanity.foobarqix.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

/**
 * The type Spring fox config.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Posts api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("foobarqix")
                .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/compute.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("FooBarQix API")
                .description("FooBarQix API reference for developers")
                .termsOfServiceUrl("http://wemanity.com")
                .contact("wemanity@gmail.com").license("wemanity License")
                .licenseUrl("wemanity@gmail.com").version("1.0").build();
    }
}