package com.jasonz.tddsampleproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParcelDTO {

    @JsonProperty(value = "parcelId")
    private String id;

    @JsonProperty(value = "error")
    private Error error;

    @JsonProperty(value = "accountId")
    private String accountId;

    @JsonProperty(value = "orderReference")
    private String orderReference;

    @JsonProperty(value = "product")
    private Product product;

    @JsonProperty(value = "dispatchType")
    private String dispatchType;

    @JsonProperty(value = "status")
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
    private ParcelStatus status;

    @JsonProperty(value = "parcelReference")
    private String parcelReference;

    @JsonProperty(value = "destination")
    private Address destination;

    @JsonProperty(value = "validDestination")
    private Address validDestination;

    @JsonProperty(value = "dimensions")
    private Dimensions dimensions;

    @JsonProperty(value = "weight")
    private Weight weight;

    @JsonProperty(value = "consignmentReference")
    private String consignmentReference;

    @JsonProperty(value = "trackingLabel")
    private String trackingLabel;

    @JsonProperty(value = "sortCode")
    private String sortCode;

    @JsonProperty(value = "hubCode")
    private String hubCode;

    @JsonProperty(value = "testMode")
    private Boolean testMode;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Dimensions {
        @JsonProperty(value = "length")
        private Integer length;
        @JsonProperty(value = "width")
        private Integer width;
        @JsonProperty(value = "height")
        private Integer height;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Weight {
        @JsonProperty(value = "deadWeight")
        private Double deadWeight;

        @JsonProperty(value = "cubicWeight")
        private Double cubicWeight;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Error {
        @JsonProperty(value = "code")
        private String code;
        @JsonProperty(value = "message")
        private String message;
    }

}
