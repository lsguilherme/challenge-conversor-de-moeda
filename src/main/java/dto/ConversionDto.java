package dto;

import com.google.gson.annotations.SerializedName;

public record ConversionDto(
        @SerializedName("base_code")
        String baseCode,

        @SerializedName("target_code")
        String targetCode,

        @SerializedName("conversion_rate")
        Double conversionRate,

        @SerializedName("time_last_update_unix")
        Long lastUpdate
){
}
