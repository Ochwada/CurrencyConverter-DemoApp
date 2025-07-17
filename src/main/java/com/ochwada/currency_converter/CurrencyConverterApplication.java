package com.ochwada.currency_converter;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Currency Converter application.
 * This Spring Boot application loads environment variables from a `.env` file using the dotenv-java library.
 * Specifically, it looks for the `MONGODB_URI` variable and sets it as a system property for use by Spring Data MongoDB.
 *
 * @author Ochwada
 */
@SpringBootApplication
public class CurrencyConverterApplication {

    /**
     * Main method that launches the Spring Boot application.
     *
     * @param args application arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(CurrencyConverterApplication.class, args);
    }

    //=================================== .env SETTINGS ======================================================
	static {
		// Load environment variables from .env (ignore if .env is missing, e.g., on Heroku)
		 Dotenv dotenv = Dotenv.configure()
				.ignoreIfMissing()
				.load();

		// List of environment variables
		String[] envVars = {
				"MONGODB_URI",
				"FREECURRENCY_APIKEY"
		};

		// Iterate through each variable and set it if present
		for (String key : envVars){

			String value = dotenv.get(key);

			if (value != null){
				System.setProperty(key, value);
				System.out.println("✅ " + key + " loaded and set.");
			} else {
				System.out.println("⚠\uFE0F" + key + " not found in .env file. Skipping System.setProperty.");
			}
		}

	}



}
