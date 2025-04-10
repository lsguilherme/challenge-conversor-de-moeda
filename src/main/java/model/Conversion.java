package model;

import model.enums.CurrencyCode;

public class Conversion extends AbstractModel{
    private CurrencyCode baseCode;
    private CurrencyCode targetCode;
    private Double conversionRate;
    private Long lastUpdate;

    public Conversion() {
    }

    public Conversion(CurrencyCode baseCode, CurrencyCode targetCode, Double conversionRate, Long lastUpdate) {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.conversionRate = conversionRate;
        this.lastUpdate = lastUpdate;
    }

    public CurrencyCode getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(CurrencyCode baseCode) {
        this.baseCode = baseCode;
    }

    public CurrencyCode getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(CurrencyCode targetCode) {
        this.targetCode = targetCode;
    }

    public Double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "baseCode='" + baseCode + '\'' +
                ", targetCode='" + targetCode + '\'' +
                ", conversionRate=" + conversionRate +
                ", lastUpdate=" + lastUpdate +
                ", searchAt=" + getSearchAt()+
                '}';
    }
}
