package com.jasonz.tddsampleproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    @JsonProperty(value = "product")
    private Product product;

    @JsonProperty(value = "orderReference")
    private String orderReference;

    @JsonProperty(value = "allowEmailNotifications")
    private Boolean allowEmailNotification;

    @JsonProperty(value = "allowSmsNotifications")
    private Boolean allowSmsNotifications;

    @JsonProperty(value = "businessName")
    private String businessName;

    @JsonProperty(value = "sender")
    private List<Sender> sender = new ArrayList<>();

    @JsonProperty(value = "receiver")
    private List<Receiver> receiver = new ArrayList<>();

    @JsonProperty(value = "parcels")
    private List<ParcelDTO> parcels = new ArrayList<>();

    @JsonProperty(value = "testMode")
    private Boolean testMode;

}
