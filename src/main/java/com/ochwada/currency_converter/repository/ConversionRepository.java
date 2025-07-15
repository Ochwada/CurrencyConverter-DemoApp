package com.ochwada.currency_converter.repository;


import com.ochwada.currency_converter.model.Conversion;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * *******************************************************
 * Package: com.ochwada.currency_converter.repository
 * File: ConversionRepository.java
 * Author: Ochwada
 * Date: Tuesday, 15.Jul.2025, 4:08 PM
 * Description:  Repository interface for the conversion document. Spring Data MongoDB automatically implements the
 * interface at runtime, providing built-in CRUD methods
 * Objective:
 * *******************************************************
 */


public interface ConversionRepository extends MongoRepository<Conversion, String> {

    // MongoRepository provides out-of-the-box CRUD methods

}
