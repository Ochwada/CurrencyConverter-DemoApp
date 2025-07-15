package com.ochwada.currency_converter.model;


import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * *******************************************************
 * Package: com.ochwada.currency_converter.model
 * File: Conversion.java
 * Author: Ochwada
 * Date: Tuesday, 15.Jul.2025, 3:36 PM
 * Description:  Represents a currency conversion record stored in the "conversion" collection in MongoDB.
 * - This class includes source and target currency codes, the amount to convert, the exchange rate used, and the resulting
 * converted amount.
 * Objective:
 * *******************************************************
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "conversion")
public class Conversion {
    /**
     * Unique identifier for the conversion record.
     */
    @Id
    private String id;

    /**
     * ISO 4217 code of the currency to convert from (e.g., "USD").
     */
    @NotBlank(message = "Choose Source Currency")
    private String sourceCurrency;

    /**
     * ISO 4217 code of the currency to convert to (e.g., "EUR").
     */
    @NotBlank(message = "Choose Target Currency")
    private String targetCurrency;

    /**
     * The amount to be converted. Must be a positive number.
     */
    @NotNull(message = "Add amount to be Converted")
    @Min(value = 1, message = "Amount must be greater than 0")
    private double amount;

    /**
     * The exchange rate used at the time of conversion.
     */
    private double exchangeRate;

    /**
     * The result of the currency conversion.
     */
    private double convertedAmount;


}
