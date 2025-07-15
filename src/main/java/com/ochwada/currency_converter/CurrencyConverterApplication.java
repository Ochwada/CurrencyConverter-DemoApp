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

		// Retrieve and set MongoDB URI (Set the URI as a system property if found, so Spring Boot can use it)
		String uri_mongo = dotenv.get("MONGODB_URI");
		if (uri_mongo != null ){
			System.setProperty("MONGODB_URI", uri_mongo);
			System.out.println("✅ MONGODB_URI loaded and set.");
		}else {
			System.out.println("⚠\uFE0F MONGODB_URI not found in .env file. Skipping System.setProperty.");
		}


		// Retrieve and set Free Currency API key for Spring Boot
		String free_currency = dotenv.get("FREECURRENCY_APIKEY");
		if (free_currency != null){
			System.setProperty("FREECURRENCY_APIKEY", free_currency);
			System.out.println("✅ FREECURRENCY_APIKEY loaded and set." );
		}else {
			System.out.println("⚠\uFE0F FREECURRENCY_APIKEY not found in .env file. Skipping System.setProperty.");
		}

	}



}
