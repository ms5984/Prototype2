package com.github.ms5984.economy.prototype2.common;

import com.github.ms5984.economy.prototype2.api.Balance;
import com.github.ms5984.economy.prototype2.api.Currency;
import com.github.ms5984.economy.prototype2.api.Entity;
import com.github.ms5984.economy.prototype2.api.Prototype2;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class Prototype2Impl implements Prototype2 {
    protected boolean enabled;

    /**
     * Every economy actor is designated at least as an {@link Entity}. Thus,
     * this list includes {@link Balance} and non-balance types.
     */
    @Override
    public List<Entity> getEntities() {
        return Collections.emptyList();
    }

    @Override
    public Entity getEntityByUid(UUID entityUid) {
        return null;
    }

    /**
     * TODO: decide how to store balances
     */
    @Override
    public List<Balance> getBalances() {
        return Collections.emptyList();
    }

    /**
     * Support for multiple currencies
     * @return the list of currencies currently available
     */
    @Override
    public List<Currency> getCurrencies() {
        return Collections.emptyList();
    }

    @Override
    public Currency getCurrencyByUid(UUID currencyId) {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
