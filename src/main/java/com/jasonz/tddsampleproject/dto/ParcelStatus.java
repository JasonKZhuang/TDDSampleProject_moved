package com.jasonz.tddsampleproject.dto;

public enum ParcelStatus {
    UNCONFIRMED("UNCONFIRMED"),
    CREATED("CREATED"),
    CONFIRMED("CONFIRMED");

    private final String parcelStatus;

    private ParcelStatus(String parcelStatus) {
        this.parcelStatus = parcelStatus;
    }


    @Override
    public String toString() {
        return this.parcelStatus;
    }
}