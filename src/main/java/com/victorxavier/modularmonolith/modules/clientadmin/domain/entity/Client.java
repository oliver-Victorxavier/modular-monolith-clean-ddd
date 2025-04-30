package com.victorxavier.modularmonolith.modules.clientadmin.domain.entity;

import com.victorxavier.modularmonolith.shared.domain.entity.BaseEntity;
import com.victorxavier.modularmonolith.shared.domain.valueobject.Address;
import com.victorxavier.modularmonolith.shared.domain.valueobject.Id;

import java.time.LocalDateTime;

public class Client extends BaseEntity {
    private final String name;
    private final String email;
    private final Address address;

    public Client(Id id, String name, String email, Address address,
                  LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(id != null ? id.getValue() : null);
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Client(String name, String email, Address address) {
        this(null, name, email, address);
    }

    public Client(Id id, String name, String email, Address address) {
        this(id, name, email, address, null, null);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
