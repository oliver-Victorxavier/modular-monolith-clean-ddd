package com.victorxavier.modularmonolith.shared.domain.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseEntity {
    private final UUID id;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    protected BaseEntity(UUID id) {
        this.id = id != null ? id : UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    protected BaseEntity() {
        this(null);
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}