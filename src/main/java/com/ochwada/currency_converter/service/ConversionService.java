package com.ochwada.currency_converter.service;


import com.ochwada.currency_converter.client.CurrencyApiClient;
import com.ochwada.currency_converter.model.Conversion;
import com.ochwada.currency_converter.repository.ConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *******************************************************
 * Package: com.ochwada.currency_converter.service
 * File: ConversionService.java
 * Author: Ochwada
 * Date: Tuesday, 15.Jul.2025, 4:10 PM
 * Description: {@code ConversionService} is the service layer for currency conversion operations. This class contains
 * the core business logic for converting currencies, persisting conversion data, and interacting with external APIs.
 * *
 * - Annotated with {@link Service} to indicate that this class is a Spring-managed component responsible for
 * application-level logic.
 * Objective: Encapsulate and organize business rules for the currency conversion process, separating concerns from both
 * the controller and data access layers.
 * *******************************************************
 */

@Service
public class ConversionService {

    /**
     * Repository used to interact with the MongoDB "conversion" collection.
     */
    private final ConversionRepository repository;


    /**
     * API client used to fetch exchange rates from the external currency API.
     */
    private final CurrencyApiClient client;

    /**
     * Constructs a new {@code ConversionService} with required dependencies.
     *
     * @param repository the {@link ConversionRepository} used for database operations
     * @param client the {@link CurrencyApiClient} used to retrieve exchange rates
     */
    @Autowired
    public ConversionService(ConversionRepository repository, CurrencyApiClient client) {
        this.repository = repository;  // Data Access Object.
        this.client = client; // External API Client.
    }


    /** -------------------------------------------------------------------------------------
     * Add business logic methods here, such as:
     * 1. saveConversion()
     * 2. getAllConversions()
     * 3. convertAmount()
     ----------------------------------------------------------------------------------------*/

    public Conversion saveConversion(Conversion conversion){
        return repository.insert(conversion);
    }
}
