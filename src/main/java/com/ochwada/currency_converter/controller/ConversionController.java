package com.ochwada.currency_converter.controller;


import com.ochwada.currency_converter.model.Conversion;
import com.ochwada.currency_converter.service.ConversionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * *******************************************************
 * Package: com.ochwada.currency_converter.controller
 * File: ConversionController.java
 * Author: Ochwada
 * Date: Wednesday, 16.Jul.2025, 2:43 PM
 * Description: EST controller that handles endpoints for currency conversion operations.
 * Objective:
 * *******************************************************
 */

@RestController
@RequestMapping("/api/conversion")
public class ConversionController {

    private final ConversionService service;

    /**
     * Constructs a new {@code ConversionController} and injects the {@link ConversionService}.
     *
     * @param service the service layer responsible for conversion logic and database interaction
     */
    @Autowired
    public ConversionController(ConversionService service) {
        this.service = service;

    }

    /**
     * Handles POST requests to create a new conversion record.
     * The conversion data (source/target currencies and amount) is sent in the request body,
     * and the exchange rate and converted amount are calculated internally before saving.
     *
     * @param conversion the {@link Conversion} object containing user input
     * @return the saved {@link Conversion} object including calculated fields and MongoDB ID
     */
    @PostMapping
    public Conversion addConversion(@Valid @RequestBody Conversion conversion){
       return service.saveConversion(conversion);
    }

    /**
     * Handles GET requests to fetch all stored conversion records.
     *
     * @return a list of all {@link Conversion} records in the database
     */
    @GetMapping
    public List<Conversion> getAllConversion(){
        return  service.getAllConversions();
    }

    /**
     * Handles GET requests to fetch a single conversion record by its ID.
     *
     * @param id the unique identifier of the conversion record
     * @return a {@link ResponseEntity} containing the {@link Conversion} if found,
     *         or a 404 Not Found response if it does not exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Conversion> getConversionById(@PathVariable String id){
        Optional<Conversion> conversion = service.getConversionById(id);

        if (conversion.isPresent()){
            return ResponseEntity.ok(conversion.get());// HTTP 200 + JSON body
        } else {
            return ResponseEntity.notFound().build();// HTTP 404, no body
        }

        //return conversion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    /**
     * Handles DELETE requests to remove a conversion record by its ID.
     *
     * @param id the unique identifier of the conversion record to be deleted
     * @return a {@link ResponseEntity} with HTTP 204 No Content if deletion is successful
     */
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteConversion(@PathVariable String id){
        service.deleteConversion(id);
        return ResponseEntity.noContent().build();
    }

}
