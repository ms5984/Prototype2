package com.github.ms5984.economy.prototype2.api;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public interface Entity {
    /**
     * A human-readable name that does not need to be unique
     * Examples:
     * "John Smith" for one of many John Smiths
     * "ACME Co."
     * @return name of the entity
     */
    String friendlyName();

    /**
     * Uniquely identifies an entity
     * @return the uid
     */
    @NotNull
    UUID getUid();
}
