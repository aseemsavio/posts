package com.aseemsavio.responsio.posts.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springfox.documentation.service.ApiInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class SpringFoxConfigTest {

    SpringFoxConfig springFoxConfigObject;

    @BeforeEach
    void setUp() {
        springFoxConfigObject = new SpringFoxConfig();
    }

    @AfterEach
    void tearDown() {
        springFoxConfigObject = null;
    }

    @Test
    void metaData() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = SpringFoxConfig.class.getDeclaredMethod("metaData");
        method.setAccessible(true);
        ApiInfo apiInfo = new ApiInfo(
                "Posts for Responsio",
                "REST Microservice for Project Responsio - Posts",
                "1.0",
                "Terms of service",
                "Aseem Savio",
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");

        apiInfo = (ApiInfo) method.invoke(springFoxConfigObject);
        assertNotNull(apiInfo);
        assertEquals("Posts for Responsio", apiInfo.getTitle());
        assertEquals("REST Microservice for Project Responsio - Posts", apiInfo.getDescription());
        assertEquals("1.0", apiInfo.getVersion());
        assertEquals("Terms of service", apiInfo.getTermsOfServiceUrl());
        assertEquals("Aseem Savio", apiInfo.getContact().getName());
        assertEquals("Apache License Version 2.0", apiInfo.getLicense());
        assertEquals("https://www.apache.org/licenses/LICENSE-2.0", apiInfo.getLicenseUrl());

    }
}