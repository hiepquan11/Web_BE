package com.huynhduc.WebBE.Config;

import com.huynhduc.WebBE.Entity.Category;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {
    private String url = "http://localhost:8080";

    // config disable methods
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//        HttpMethod[] BlocksMethod = {
//                HttpMethod.POST,
//                HttpMethod.DELETE,
//                HttpMethod.PATCH,
//                HttpMethod.PUT
//        };
//        DisableHttpsMethod(Category.class, config, BlocksMethod);
    }
    private void DisableHttpsMethod(Class c, RepositoryRestConfiguration config, HttpMethod[] methods){
        config.getExposureConfiguration()
                .forDomainType(c)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(methods)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable());
    }
}
