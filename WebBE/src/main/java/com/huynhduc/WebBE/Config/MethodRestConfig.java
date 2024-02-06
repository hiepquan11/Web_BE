package com.huynhduc.WebBE.Config;

import com.huynhduc.WebBE.Entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MethodRestConfig implements RepositoryRestConfigurer {
    private String url = "http://localhost:3000";

    @Autowired
    private EntityManager entityManager;

    // config disable methods
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));

        // Cors configuration
        cors.addMapping("/**").allowedOrigins(url).allowedMethods("GET","POST","PUSH","DELETE");
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
