package com.victorxavier.modularmonolith.shared.domain.valueobject;

import java.util.UUID;

public class Id {
    private final UUID value;

    public Id() {
        this.value = UUID.randomUUID();
    }

    public Id(UUID id) {
        this.value = id != null ? id : UUID.randomUUID();
    }

    public Id(String id) {
        try {
            this.value = UUID.fromString(id);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Invalid UUID format: " + id, ex);
        }
    }

    public String toString() {
        return value.toString();
    }

    public UUID getValue() {
        return value;
    }
}
