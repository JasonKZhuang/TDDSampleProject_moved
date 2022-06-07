package com.jasonz.tddsampleproject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sender {
    @JsonProperty(value = "firstName")
    protected String firstName;

    @JsonProperty(value = "lastName")
    protected String lastName;

    @JsonProperty(value = "businessName")
    private String businessName;

    @JsonProperty(value = "phone")
    protected String phone;

    @JsonProperty(value = "email")
    protected String email;
}
