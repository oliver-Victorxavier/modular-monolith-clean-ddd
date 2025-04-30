package com.victorxavier.modularmonolith.shared.domain.valueobject;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address {

    @Column(nullable = false)
    private String street;

    private String number;
    private String complement;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column(name = "zip_code", nullable = false)
    private String zipCode;

    protected Address() {
        // obrigatório para JPA
    }

    public Address(String street, String number, String complement,
                   String city, String state, String zipCode) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        validate();
    }

    private void validate() {
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("Street is required");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City is required");
        }
        if (state == null || state.isBlank()) {
            throw new IllegalArgumentException("State is required");
        }
        if (zipCode == null || zipCode.isBlank()) {
            throw new IllegalArgumentException("ZipCode is required");
        }
    }

    public String fullAddress() {
        return String.format("%s, %s%s, %s, %s, %s",
                street, number,
                (complement != null && !complement.isBlank()) ? ", " + complement : "",
                city, state, zipCode);
    }

    // Getters
    public String getStreet()     { return street; }
    public String getNumber()     { return number; }
    public String getComplement() { return complement; }
    public String getCity()       { return city; }
    public String getState()      { return state; }
    public String getZipCode()    { return zipCode; }

    // equals & hashCode (obrigatório para @Embeddable ser confiável)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(street, address.street) &&
                Objects.equals(number, address.number) &&
                Objects.equals(complement, address.complement) &&
                Objects.equals(city, address.city) &&
                Objects.equals(state, address.state) &&
                Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, complement, city, state, zipCode);
    }
}
