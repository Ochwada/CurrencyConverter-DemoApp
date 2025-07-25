package com.ochwada.currency_converter.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * *******************************************************
 * Package: com.ochwada.currency_converter.config
 * File: RestTemplateConfig.java
 * Author: Ochwada
 * Date: Tuesday, 15.Jul.2025, 5:34 PM
 * Description: {@code RestTemplateConfig} is a configuration class that defines application-wide Spring beans related to
 * REST communication.
 * - This class provides a single {@link org.springframework.web.client.RestTemplate} bean, which can be injected into
 * other components (e.g., {@link com.ochwada.currency_converter.client.CurrencyApiClient}) to perform HTTP requests to
 * external APIs.
 * Objective: Centralize the creation and reuse of a {@code RestTemplate} instance to promote clean and maintainable
 * REST client configuration across the application.
 * *******************************************************
 */


/**
 * Spring {@code @Configuration} class that defines the {@link RestTemplate} bean.
 * *
 * By declaring this bean in a central place, it ensures that the same {@code RestTemplate} instance can be injected and
 * reused throughout the application for making HTTP requests.
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Creates and exposes a {@link RestTemplate} bean for making HTTP requests.
     *
     * @return a default RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
