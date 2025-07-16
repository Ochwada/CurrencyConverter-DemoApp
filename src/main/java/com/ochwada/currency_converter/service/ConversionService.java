package com.ochwada.currency_converter.service;


import com.ochwada.currency_converter.client.CurrencyApiClient;
import com.ochwada.currency_converter.model.Conversion;
import com.ochwada.currency_converter.repository.ConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
     * @param client     the {@link CurrencyApiClient} used to retrieve exchange rates
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
    /**
     * Saves a currency conversion record to the MongoDB <strong>"conversion"</strong> collection.
     * *
     * This method first fetches the current exchange rate between the provided source and target currencies
     * using {@link CurrencyApiClient#getExchangeRate(String, String)}. It then populates the {@link Conversion}
     * object with the current exchange rate, default amount (1.0), and the calculated converted amount before
     * saving it using {@link ConversionRepository#insert(Object)}.
     *
     * @param conversion the {@link Conversion} object to be saved, containing the source and target currency codes;
     *                   the method will fill in the latest exchange rate, amount, and converted amount
     * @return the saved {@link Conversion} object, including its generated MongoDB ID
     *
     * @throws RuntimeException if the exchange rate could not be fetched or the save operation fails
     */
    public Conversion saveConversion(Conversion conversion) {
        //return repository.insert(conversion);
        CurrencyApiClient.CurrencyData currencyData = client.getExchangeRate(
                conversion.getSourceCurrency(),
                conversion.getTargetCurrency()
        );

        // Populate conversion object with the fetched data
        conversion.setAmount(currencyData.getAmount());
        conversion.setExchangeRate(currencyData.getExchangeRate());
        conversion.setConvertedAmount(currencyData.getConvertedAmount());

        // Save the populated object to the MongoDB collection
        return  repository.insert(conversion);
    }

    /**
     * Retrieves all currency conversion records from the MongoDB "conversion" collection.
     *
     * @return a {@link List} of all {@link Conversion} records stored in the database
     */
    public List<Conversion> getAllConversions(){
        return repository.findAll();
    }

    /**
     * Retrieves a specific currency conversion record by its unique MongoDB ID.
     *
     * @param id the ID of the conversion record to retrieve
     * @return an {@link Optional} containing the {@link Conversion} if found, or empty if not found
     */
    public Optional<Conversion> getConversionById(String id){
        return repository.findById(id);
    }

    /**
     * Deletes a currency conversion record from the MongoDB "conversion" collection by its ID.
     *
     * @param id the ID of the conversion record to delete
     */
    public void deleteConversion(String id){
        repository.deleteById(id);
    }


}
