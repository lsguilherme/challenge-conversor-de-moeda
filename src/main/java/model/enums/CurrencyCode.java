package model.enums;

public enum CurrencyCode {
    ARS("Peso argentino"),
    BOB("Boliviano boliviano"),
    BRL("Real brasileiro"),
    CLP("Peso chileno"),
    COP("Peso colombiano"),
    USD("Dólar americano");

    private final String description;

    CurrencyCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static CurrencyCode fromString(String code){
        return CurrencyCode.valueOf(code);
    }
}
