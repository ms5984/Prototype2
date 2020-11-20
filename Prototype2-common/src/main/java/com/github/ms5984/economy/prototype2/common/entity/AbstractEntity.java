package com.github.ms5984.economy.prototype2.common.entity;

import com.github.ms5984.economy.prototype2.api.Entity;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public abstract class AbstractEntity implements Entity {
    protected String friendlyName;
    protected UUID uuid;

    protected AbstractEntity() {
        // for deserialization
    }
    protected AbstractEntity(String friendlyName, UUID uuid) {
        this.friendlyName = (friendlyName == null) ? "" : friendlyName;
        this.uuid = uuid;
    }

    @Override
    public String friendlyName() {
        return friendlyName;
    }

    @Override
    public @NotNull UUID getUid() {
        return uuid;
    }
}
