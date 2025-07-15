package com.ochwada.currency_converter.client;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * *******************************************************
 * Package: com.ochwada.currency_converter.client
 * File: CurrencyApiClient.java
 * Author: Ochwada
 * Date: Tuesday, 15.Jul.2025, 4:19 PM
 * Description: Client to fetch currency data from FreeCurrency API
 * Objective:
 * *******************************************************
 */

/**
 * {@code CurrencyApiClient} is a Spring-managed component that provides access to weather data from the FreeCurrency API.
 * Annotated with {@link org.springframework.stereotype.Component}, this class is automatically detected and instantiated
 * by Spring's component scanning mechanism. It becomes eligible for dependency injection wherever needed in the application.
 * *
 * - The API key and base URL for the FreeCurrency service are injected from the application's configuration (e.g.,
 * {@code application.properties} or environment variables) using the {@link org.springframework.beans.factory.annotation.Value} annotation.
 * *
 * -Uses {@link RestTemplate} to send HTTP requests and {@link ObjectMapper} to handle JSON parsing. The API key and URL
 * are injected from application properties.
 */
@Component
public class CurrencyApiClient {

    /**
     * Spring's RestTemplate used to send HTTP requests to the currency API.
     */
    private final RestTemplate restTemplate;

    /**
     * Jackson ObjectMapper for converting JSON responses to Java objects.
     */
    private final ObjectMapper objectMapper;


    /**
     * The API key for accessing the FreeCurrency API. Injected from application properties.
     */
    @Value("${freecurrency.api.key}")
    private String apiKey;

    /**
     * The base URL of the FreeCurrency API. Injected from application properties.
     */
    @Value("${freecurrency.api.url}")
    private String apiUrl;

    /**
     * Constructs a {@code CurrencyApiClient} with the given RestTemplate.
     *
     * @param restTemplate the RestTemplate used for making HTTP requests
     */
    @Autowired
    public CurrencyApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.objectMapper = new ObjectMapper();
    }


    /**
     * Fetches the latest exchange rate from the source currency to the target currency using the FreeCurrency API.
     * *
     * Example API request:
     * {@code https://api.freecurrencyapi.com/v1/latest?apikey=YOUR_API_KEY&base_currency=USD&currencies=EUR}
     *
     * @param sourceCurrency the 3-letter ISO code of the source currency (e.g., "USD")
     * @param targetCurrency the 3-letter ISO code of the target currency (e.g., "EUR")
     * @return the exchange rate from sourceCurrency to targetCurrency
     * @throws RuntimeException if the API call fails or the rate cannot be parsed
     */
    public double getExchangeRate(String sourceCurrency, String targetCurrency) {
        // Construct the API request URL using source and target currencies
        String url = String.format(
                "%s?apikey=%s&base_currency=%s&currencies=%s",
                apiUrl,
                apiKey,
                sourceCurrency,
                targetCurrency
        );

        try {
            // Send GET request to the currency API
            String response = restTemplate.getForObject(url, String.class);

            // Parse the JSON response to extract the exchange rate
            JsonNode root = objectMapper.readTree(response);
            JsonNode data = root.path("data").path(targetCurrency);

            // Return the exchange rate value
            return data.asDouble();
        } catch (Exception e) {
            // Wrap any exceptions in a RuntimeException with a custom message
            throw new RuntimeException("Failed to fetch currency conversion data: " + e.getMessage());
        }
    }

}
