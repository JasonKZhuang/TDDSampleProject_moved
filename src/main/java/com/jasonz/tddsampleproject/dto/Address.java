package com.jasonz.tddsampleproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Address  {
    @JsonProperty(value = "id")
    private String id;

    @JsonProperty(value = "streets")
    private List<String> streets = new ArrayList<>();

    @JsonProperty(value = "suburb")
    private String suburb;
    @JsonProperty(value = "state")
    private String state;
    @JsonProperty(value = "postcode")
    private String postcode;
    @JsonProperty(value = "country")
    private String country = "AU";

    @JsonProperty(value = "isValid")
    protected Boolean isValid = false;

}