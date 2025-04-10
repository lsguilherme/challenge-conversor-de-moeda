package service;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ConversionService {
    /**
     * Converte um valor de uma moeda para outra.
     * @param amount
     * @param conversionRate
     */
    public static Double convertCurrency(Double amount, Double conversionRate) {
        if (conversionRate <= 0) {
            throw new IllegalArgumentException("Exchange rate must be positive.");
        }

        if (amount == null || conversionRate == null) {
            throw new IllegalArgumentException("Amount and conversion rate cannot be null.");
        }

        return amount * conversionRate;
    }

    /**
     * Converte um valor Unix para o horario de Brasilia.
     * @param lastTime
     */
    public static String convertToBrasiliaTime(Long lastTime) {
        if (lastTime == null) {
            throw new IllegalArgumentException("Last time cannot be null.");
        }
        try {
            Instant instant = Instant.ofEpochSecond(lastTime);
            ZonedDateTime brasiliaTime = instant.atZone(ZoneId.of("America/Sao_Paulo"));

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z");

            return dtf.format(brasiliaTime);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Invalid timestamp value", e);
        }


    }

}

