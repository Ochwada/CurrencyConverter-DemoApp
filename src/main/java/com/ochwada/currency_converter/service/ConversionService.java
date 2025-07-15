package com.ochwada.currency_converter.service;


import com.ochwada.currency_converter.repository.ConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *******************************************************
 * Package: com.ochwada.currency_converter.service
 * File: ConversionService.java
 * Author: Ochwada
 * Date: Tuesday, 15.Jul.2025, 4:10 PM
 * Description: {@code ConversionService} Service layer for Conversion operations. This class handles business logics
 * - Annotated with {@link Service} to indicate that this class is a Spring-managed component responsible for
 * application-level logic.
 * Objective:
 * *******************************************************
 */

@Service
public class ConversionService {

    /**
     * Repository used to interact with the MongoDB "conversion" collection.
     */
    private final ConversionRepository repository;


    /**
     * Constructs a new {@code ConversionService} with the given repository.
     *
     * @param repository the {@link ConversionRepository} used for database operations
     */
    @Autowired
    public ConversionService(ConversionRepository repository) {
        this.repository = repository;
    }

    /** -------------------------------------------------------------------------------------
     * Add business logic methods here, such as:
     * 1. saveConversion()
     * 2. getAllConversions()
     * 3. convertAmount()
     ----------------------------------------------------------------------------------------*/
}
