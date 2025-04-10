import com.google.gson.Gson;
import config.HttpService;
import dto.ConversionDto;
import model.Conversion;
import model.enums.CurrencyCode;

import java.util.Scanner;

import static service.ConversionService.*;

public class Main {

    private static final Gson gson = new Gson();
    private static final String[] SUPPORT_CURRENCIES = {
            "ARS (Peso argentino)",
            "BOB (Boliviano boliviano)",
            "BRL (Real brasileiro)",
            "CLP (Peso chileno)",
            "COP (Peso colombiano)",
            "USD (Dólar americano)"
    };


    public static void main(String[] args) {
        displayWelcome();

        try (Scanner sc = new Scanner(System.in)) {
            String baseCode = sc.nextLine();

            System.out.println("Escolha a moeda de saida:");
            String targetCode = sc.nextLine();

            System.out.println("Digite o valor da conversão: ");
            Double amount = Double.valueOf(sc.nextLine());

            var req = HttpService.request(baseCode, targetCode);

            ConversionDto conversionDto = gson.fromJson(req, ConversionDto.class);

            Conversion c = new Conversion(CurrencyCode.fromString(conversionDto.baseCode()), CurrencyCode.fromString(conversionDto.targetCode()), conversionDto.conversionRate(), conversionDto.lastUpdate());
            System.out.println();
            System.out.println("""
                *********************************
                *     RESULTADO DA CONVERSÃO    *
                *********************************""");
            System.out.printf("- %.2f  %s = %.2f  %s. %n", amount, c.getBaseCode(), convertCurrency(amount, c.getConversionRate()), c.getTargetCode());
            System.out.println("- Última atualização: " + convertToBrasiliaTime(c.getLastUpdate()));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Exibe a mensagem de boas-vindas com as moedas suportadas pelo sistema atualmente.
     */
    private static void displayWelcome() {
        System.out.println("""
                *********************************
                *       CONVERSOR DE MOEDAS     *
                *********************************
                Moedas suportadas:""");

        for (String currency : SUPPORT_CURRENCIES) {
            System.out.println("- " + currency);
        }
        System.out.println();
        System.out.println("Escolha a moeda que você quer converter:");
    }

}
